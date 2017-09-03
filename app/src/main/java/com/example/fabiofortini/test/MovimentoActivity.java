package com.example.fabiofortini.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MovimentoActivity extends AppCompatActivity {
    Button procedi;
    EditText valore;
    String val;
    Double amount;
    float amountFloat;
    RadioButton togli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento);

        procedi = (Button) findViewById(R.id.procedi);
        valore = (EditText) findViewById(R.id.valore);
        togli = (RadioButton) findViewById(R.id.delete);

        procedi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = valore.getText().toString();
                if(val.trim().isEmpty()) {
                    //se il testo è vuoto setto come valore 0.00
                    valore.setText("0.00");
                } else {
                    //test se la stringa non è valida

                    try {
                         amount = Double.parseDouble(val);
                    } catch(Exception e) {
                        //da modificare (Carle)
                        valore.setText("0.00");
                    }
                    amountFloat = amount.floatValue();
                    if (togli.isChecked())
                        amountFloat=amountFloat*-1;
                    System.out.println(amountFloat);
                }
            }
            //TODO aggiungere rinvio a pagina iniziale e salvataggio su file

        });
    }
}
