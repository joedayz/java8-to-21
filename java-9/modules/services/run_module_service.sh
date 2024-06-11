# crear el directorio temp
mkdir -p output/mlibs

# Construir el modulo service provider
echo "Building provider module"
mkdir output/classes
javac -d output/classes --module-version 1.0 `find provider -name "*.java"`
jar -cf output/mlibs/provider-1.0.jar -C output/classes .
rm -rf output/classes

# Construir el modulo service consumer
echo "Building consumer module"
mkdir output/classes
javac -p output/mlibs -d output/classes --module-version 1.0 `find consumer -name "*.java"`
jar -c -f output/mlibs/consumer-1.0.jar \
 --main-class pe.joedayz.consumer.MadScientist \
 -C output/classes .
 rm -rf output/classes

 echo "Running"
 java -p output/mlibs -m consumer