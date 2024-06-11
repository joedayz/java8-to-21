module provider {


    exports pe.joedayz.provider;

    provides pe.joedayz.provider.Calculator with pe.joedayz.provider.impl.HitchCalculator;

}