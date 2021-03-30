package com.example.icarealot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.btnlogin);
        username=(EditText)findViewById(R.id.txtuser);
        password=(EditText)findViewById(R.id.txtpass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void login(){
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("mayra") && pass.equals("mayra")){
            Toast.makeText(this,"Conectado! :D",Toast.LENGTH_LONG).show();
            IrPrincipal();
        }else {
            Toast.makeText(this,"Usuario ou Login Inválido",Toast.LENGTH_LONG).show();
        }
    }

    private void IrPrincipal() {
        Intent principal  =  new  Intent( Login.this , Principal.class );
        startActivity ( principal );
    }
}