import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import jdk.incubator.concurrent.StructuredTaskScope;

public class StructuredConcurrencyMotivation {
    public static void main(String[] args) {
        var example = new StructuredConcurrencyMotivation();

        System.out.println("\nExecutorService:");

        try {
            System.out.println(example.unstructuredHandle());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nStructuredTaskScope:");

        try {
            System.out.println(example.structuredHandle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Problemas:
     * - Si findUser lanza una excepción, entonces handle lanzará una excepción al llamar a user.get(). fetchOrder continuará ejecutándose en su propio
     *   hilo incluso después de que handle haya fallado. Esto es una fuga de hilos, que, en el mejor de los casos, desperdicia recursos;
     *   en el peor de los casos, fetchOrder interferirá con otras tareas.
     * - Si el hilo que ejecuta handle es interrumpido, la interrupción no se propaga a las subtareas. Ambos hilos de findUser
     *   y fetchOrder se filtrarán, continuando su ejecución incluso después de que handle haya fallado.
     * - Si findUser tarda mucho en ejecutarse, pero fetchOrder falla mientras tanto, handle esperará innecesariamente
     *   a findUser bloqueándose en user.get() en lugar de cancelarlo. Solo después de que findUser complete y user.get()
     *   regrese, order.get() lanzará una excepción, causando que handle falle.
     */
    Response unstructuredHandle() throws ExecutionException, InterruptedException {
        var es = Executors.newCachedThreadPool();
        try {
            Future<String> user = es.submit(() -> findUser());
            Future<Integer> order = es.submit(() -> fetchOrder());
            String theUser = user.get(); // Esperar a que findUser complete
            int theOrder = order.get(); // Esperar a que fetchOrder complete
            return new Response(theUser, theOrder);
        } finally {
            es.shutdown();
        }
    }

    /**
     * Beneficios:
     * - Manejo de errores con interrupción inmediata: Si findUser o fetchOrder fallan, el otro será cancelado si
     *   aún no ha completado (esto es gestionado por la política de cancelación implementada por ShutdownOnFailure;
     *   también son posibles otras políticas).
     * - Propagación de la cancelación: Si el hilo que ejecuta handle es interrumpido antes o durante la llamada a join, ambos
     *   forks serán automáticamente cancelados cuando el scope sea salido.
     * - Claridad: El código anterior tiene una estructura clara: configurar las subtareas hijas, esperar por ellas (ya sea para completar
     *   o ser canceladas), y luego decidir si tener éxito (y procesar los resultados de las tareas hijas, que ya han terminado) o fallar (y las subtareas ya han terminado, por lo que no hay nada más que limpiar).
     * - Observabilidad: Un volcado de hilos mostrará claramente la jerarquía de tareas, con los hilos
     *   ejecutando findUser y fetchOrder mostrados como hijos del scope.
     */
    Response structuredHandle() throws ExecutionException, InterruptedException {
          try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
              Future<String> userTask = scope.fork(this::findUser);
              Future<Integer> orderTask = scope.fork(this::fetchOrder);
  
              scope.join(); // Esperar a que ambos forks completen
              scope.throwIfFailed(); // ... y propagar errores
  
              // Aquí, ambos forks han tenido éxito, así que componer sus resultados
              return new Response(userTask.get(), orderTask.get());
          }
      }

    String findUser() {
        System.out.println("Finding user");
        sleep("Finding user");
        System.out.println("Found user");
        return "Marley";
    }

    Integer fetchOrder() {
        System.out.println("Fetching order");
        sleep("Fetching order");
        throw new RuntimeException("Failed to fetch order");
        // System.out.println("Fetched order");
        // return Integer.valueOf(42);
    }

    void sleep(String task) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(task + " canceled");
        }
    }

    record Response(String user, Integer order) {}
}
