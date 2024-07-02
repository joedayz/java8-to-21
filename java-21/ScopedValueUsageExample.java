import java.util.concurrent.*;


public class ScopedValueUsageExample {
          
          final static ScopedValue<String> MAIN_SCOPE = ScopedValue.newInstance();

          public static void main(String[] args) {
		System.out.println("Starting scoped value");

		// we can share a value from here
		ScopedValue.where(MAIN_SCOPE, "message from main")
			.run(() -> {
				var worker = new Worker();
				worker.execute();
			});
		System.out.println("main ending");
	}

}

class Worker {
	final static ScopedValue<String> WORKER_SCOPE = ScopedValue.newInstance();

          public void execute() {
		// accessing the value from the scope
		System.out.println("shared value from main: " + ScopedValueUsageExample.MAIN_SCOPE.get());

                    // === Nested Scope ===
		// we can create a nested scope
		ScopedValue.where(WORKER_SCOPE, "message from worker")
                    .run(() -> {
                              // the outmost scope will still works
                              var messageFromMain = ScopedValueUsageExample.MAIN_SCOPE.get();
                              var messageFromWorker = WORKER_SCOPE.get();
                              System.out.println("shared value to inner scope from main: " + messageFromMain);
                              System.out.println("shared value to inner scope from worker: " + messageFromWorker);
                    });

                    ScopedValue.where(ScopedValueUsageExample.MAIN_SCOPE, "message from worker over main")
                    .run(() -> {
                              // the outmost scope will still works
                              var rebindedMessage = ScopedValueUsageExample.MAIN_SCOPE.get();
                              System.out.println("shared value from shadowed scope: " + rebindedMessage);
                    });

                    		// but the original scope from main will still have its initial value (immutable)
		System.out.println("shared value from main after all scopes: " + ScopedValueUsageExample.MAIN_SCOPE.get());
          }
}

