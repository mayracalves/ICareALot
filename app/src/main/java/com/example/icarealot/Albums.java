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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Albums extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener {

    List<com.example.icarealot.model.Albums> albums =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);

        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd:"+albums.size(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                com.example.icarealot.model.Albums obj = new com.example.icarealot.model.Albums(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"));
                albums.add(obj);

            }
            Toast.makeText(this,"qtd:"+albums.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(com.example.icarealot.model.Albums obj1 : albums) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        com.example.icarealot.model.Albums albums = (com.example.icarealot.model.Albums) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalhesAlbumsActivity.class);
//
//                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objPost", albums);
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