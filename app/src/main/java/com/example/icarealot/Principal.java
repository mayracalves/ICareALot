package com.example.icarealot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Principal extends AppCompatActivity {

    Button login, splash, post, comments, albums, photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        login=(Button)findViewById(R.id.btnVoltarLogin);
        splash=(Button)findViewById(R.id.btnVoltarSplash);
        post=(Button)findViewById(R.id.btnPost);
        comments=(Button)findViewById(R.id.btnComments);
        albums=(Button)findViewById(R.id.btnAlbums);
        photos=(Button)findViewById(R.id.btnPhotos);

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

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrPost();
            }
        });

        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irComments();
            }
        });

        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAlbums();
            }
        });

        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrPhotos();
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

    private void IrPost() {
        Intent post  =  new  Intent( Principal.this , Post.class );
        startActivity ( post );
    }

    private void irComments() {
        Intent comments  =  new  Intent( Principal.this , Comments.class );
        startActivity ( comments );
    }

    private void IrAlbums() {
        Intent albums  =  new  Intent( Principal.this , Albums.class );
        startActivity ( albums );
    }

    private void IrPhotos() {
        Intent photos  =  new  Intent( Principal.this , Photos.class );
        startActivity ( photos );
    }




}