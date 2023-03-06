package br.edu.ifsp.app2_conversortemperatura;

public class FarenStrategy implements ConversorTemperatura {
    private static final FarenStrategy farenStrategy = new FarenStrategy();

    public static FarenStrategy getInstance(){
        return farenStrategy;
    }

    @Override
    public Double getConversion(Double temp) {
        Double value;
        value = (1.8*temp)+32;
        return value;
    }
}