package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.VerifiedKeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText dolares, euros;
    private TextView resultado;
    private final double euroDolar= 1.18473;//un dolar 0.84... euros
    private final double dolarEuro= 0.844071;//un euro 1.18... dolares
    private RadioButton rbDolarEu, rbEuroD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz);

        dolares=(EditText)findViewById(R.id.editTextDolar);
        euros=(EditText)findViewById(R.id.editTextEuros);
        resultado=(TextView)findViewById(R.id.textResultado);
        rbEuroD=(RadioButton)findViewById(R.id.rbaDolares);
        rbDolarEu=(RadioButton)findViewById(R.id.rbaEuros);


        rbEuroD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            euros.setEnabled(true);
            dolares.setEnabled(false);
            dolares.setText("");
            resultado.setText("");


            }
        });

        rbDolarEu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                euros.setEnabled(false);
                dolares.setEnabled(true);
                euros.setText("");
                resultado.setText("");

            }
        });


    }


    public void calcular(View v){

try{
        if(rbEuroD.isChecked()==true){
            double numEuro, conversion1, redondeo;

            String euro = euros.getText().toString();
            numEuro = Double.parseDouble(euro);
            conversion1 = numEuro*euroDolar;
            redondeo= Math.round(conversion1 * 1000000)/1000000d;
            String euroD= String.valueOf(redondeo);
            resultado.setText(euroD);


        }else if (rbDolarEu.isChecked()==true){
            double numDolar, conversion2, redondeo;

            String dolar = dolares.getText().toString();
            numDolar= Double.parseDouble(dolar);
            conversion2 = numDolar*dolarEuro;
            redondeo= Math.round(conversion2 * 1000000d)/1000000d;
            String dolarEu= String.valueOf(redondeo);
            resultado.setText(dolarEu);
        }
    }catch(Exception ex){
        Toast.makeText(this, "Debe ingresar un valor", Toast.LENGTH_LONG).show();
        }
}

}