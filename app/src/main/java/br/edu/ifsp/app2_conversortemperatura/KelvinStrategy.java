package br.edu.ifsp.app2_conversortemperatura;

public class KelvinStrategy implements  ConversorTemperatura{
    private static final KelvinStrategy kelvinStrategy = new KelvinStrategy();

    public static KelvinStrategy getInstance(){
        return  kelvinStrategy;
    }

    @Override
    public Double getConversion(Double temp) {
        Double value;
        value = temp +273;
        return value;
    }
}