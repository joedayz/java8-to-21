# crear el directorio temp
mkdir -p output/mlibs

# Construir el API module
echo 'Building MathApi Module'
mkdir output/classes
#compilar los archivos
javac -d output/classes --module-version 1.0 `find math_api -name *.java`
# build the modules
jar -cf output/mlibs/mathapi-1.0.jar -C output/classes .
rm -rf output/classes

# Construir el Lib Module
echo 'Building MathImpl Module'
mkdir output/classes
#compilar los archivos
javac -p output/mlibs -d output/classes --module-version 1.0 `find math_lib -name *.java`
# build the modules
jar -cf output/mlibs/mathlib-1.0.jar -C output/classes .
rm -rf output/classes

#Building Calculator Module
mkdir output/classes
javac -p output/mlibs -d output/classes --module-version 1.0 `find calculator -name *.java`
jar -c -f output/mlibs/calculator.jar --main-class pe.joedayz.calculator.SimpleCalculator \
 -C output/classes .
rm -rf output/classes