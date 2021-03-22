package com.example.icarealot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button login, splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        login=(Button)findViewById(R.id.btnVoltarLogin);
        splash=(Button)findViewById(R.id.btnVoltarSplash);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrLogin();
            }
        });

        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrSplash();
            }
        });

    }

    private void IrLogin() {
        Intent login  =  new  Intent( Principal.this , Login.class );
        startActivity ( login );
    }

    private void IrSplash() {
        Intent splash  =  new  Intent( Principal.this , MainActivity.class );
        startActivity ( splash );
    }
}