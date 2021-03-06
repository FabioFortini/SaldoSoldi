package com.example.fabiofortini.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    protected Button movimento;
    protected TextView viewSaldoLarge;
    public static File fileSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movimento = (Button) findViewById(R.id.button);
        viewSaldoLarge = (TextView) findViewById(R.id.saldo);
        try {
            fileSave = new File("./pippo.txt");
            System.out.println("==================== FILE CREATO IN TEORIA");
            /*if (!fileSave.exists()) {
                System.out.println("STO PER CREARE IL FILEEEEEEEEEE");
                //fileSave.createNewFile();
                //chiamo la saldo activity per inserire il saldo
                Intent saldoActivity = new Intent(MainActivity.this, SaldoActivity.class);
                startActivity(saldoActivity);
            }*/
            FileInputStream fis = new FileInputStream(fileSave);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            viewSaldoLarge.setText("Saldo: " + br.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        double saldo=1000;
        viewSaldoLarge.setText("Saldo: "+saldo);


        movimento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent movimentoActivity = new Intent(MainActivity.this, MovimentoActivity.class);
                    startActivity(movimentoActivity);
            }
        });

    }


}
