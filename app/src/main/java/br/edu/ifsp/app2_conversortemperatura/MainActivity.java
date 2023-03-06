package br.edu.ifsp.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.edu.ifsp.app2_conversortemperatura.CelsiusStrategy;
import br.edu.ifsp.app2_conversortemperatura.FarenStrategy;
import br.edu.ifsp.app2_conversortemperatura.KelvinStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFarenheit;
    private Button btnConverterCelsius;
    private Button btnConverterFaren;
    private TextView viewResult;

    private CelsiusStrategy celsiusStrategy = CelsiusStrategy.getInstance();
    private FarenStrategy farenStrategy = FarenStrategy.getInstance();
    private KelvinStrategy kelvinStrategy = KelvinStrategy.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtFarenheit = findViewById(R.id.edt_farenheit);
        Button btnConverterCelsius = findViewById(R.id.btn_converte_celsius);
        Button btnConverterFaren = findViewById(R.id.btn_converte_faren);
        TextView viewResult = findViewById(R.id.viewResult);

        btnConverterCelsius.setOnClickListener(this);
        btnConverterFaren.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view == btnConverterCelsius) {
            conversionCelsius();
        }
        else if(view == btnConverterFaren){
            conversionFaren();
        }
    }

    private double getValue(){
        double value;
        String valueString;

        valueString = edtFarenheit.getText().toString();

        try {
            value = Double.valueOf(valueString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido.", Toast.LENGTH_SHORT).show();
            value = 0;
        }

        Toast.makeText(this, "Pegou", Toast.LENGTH_SHORT).show();
        return value;
    }

    private void conversionCelsius(){
        double value = celsiusStrategy.getConversion(getValue());
        viewResult.setText(String.format("%.2f °C", value));
    }

    private void conversionFaren(){
        double value = farenStrategy.getConversion(getValue());
        viewResult.setText(String.format("%.2f °C", value));
    }

    private void conversionKelvin(){
        double value = kelvinStrategy.getConversion(getValue());
        viewResult.setText(String.format("%.2f °C", value));
    }
}