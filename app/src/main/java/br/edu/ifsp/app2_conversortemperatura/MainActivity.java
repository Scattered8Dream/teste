package br.edu.ifsp.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.edu.ifsp.app2_conversortemperatura.CelsiusStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFarenheit;
    private Button btnConverter;
    private TextView viewResult;

    private CelsiusStrategy celsiusStrategy = CelsiusStrategy.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtFarenheit = findViewById(R.id.edt_farenheit);
        Button btnConverter = findViewById(R.id.btn_converte);
        TextView viewResult = findViewById(R.id.viewResult);

        btnConverter.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        Double result;
        if (view == btnConverter) {
            Toast.makeText(this, "Clicou", Toast.LENGTH_SHORT).show();
            conversionCelsius();
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

    private void conversionCelsius() {
        double value = celsiusStrategy.getConversion(getValue());
        Toast.makeText(this, "Converteu", Toast.LENGTH_SHORT).show();
        viewResult.setText(String.format("%.2f °C", value));
        //showText(value);
    }

    void showText(Double value){
        viewResult.setText(String.format("%.2f °C", value));
    }
}