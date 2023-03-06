package br.edu.ifsp.app2_conversortemperatura;

import android.view.View;

public class CelsiusStrategy implements ConversorTemperatura {

    private static final CelsiusStrategy celsiusStrategy = new CelsiusStrategy();

    public static CelsiusStrategy getInstance(){
        return celsiusStrategy;
    }

    @Override
    public Double getConversion(Double temp) {
        Double value;
        value = (temp - 32) / 1.8;
        return value;
    }
}
