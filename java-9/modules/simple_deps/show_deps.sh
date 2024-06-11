echo "MathApi Deps"

jdeps output/mlibs/mathapi-1.0.jar

echo "\nMathLib Deps"
jdeps --module-path output/mlibs/ output/mlibs/mathlib-1.0.jar

echo "\nCalculator Deps"
jdeps --module-path output/mlibs/ output/mlibs/calculator.jar