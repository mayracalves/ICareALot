package com.example.icarealot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.icarealot.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Principal extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<Post> posts =  new ArrayList<>();
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


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);

        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd:"+posts.size(),Toast.LENGTH_LONG).show();

    }

    private void IrLogin() {
        Intent login  =  new  Intent( Principal.this , Login.class );
        startActivity ( login );
    }

    private void IrSplash() {
        Intent splash  =  new  Intent( Principal.this , MainActivity.class );
        startActivity ( splash );
    }

    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Post obj = new Post(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body"));
                posts.add(obj);

            }
            Toast.makeText(this,"qtd:"+posts.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(Post obj1 : posts) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Post post = (Post) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalhePostActivity.class);
//
//                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objPost", post);
//                        // lança intent para o SO chamar a activity
                        startActivity(intent);
//                        Toast.makeText(v.getContext(),post.getId()+" - "+post.getTitle(),Toast.LENGTH_LONG).show();
                    }
                });
                ll.addView(bt);
            }

        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }


}