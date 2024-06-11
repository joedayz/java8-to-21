jlink --module-path $JAVA_HOME/jmods:output/mlibs \
  --add-modules simplecalculator \
  --launcher simplecalculator=simplecalculator/pe.joedayz.calculator.SimpleCalculator \
  --output output/simplecalculator
