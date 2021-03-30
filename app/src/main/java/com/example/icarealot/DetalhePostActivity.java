package com.example.icarealot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.icarealot.model.Post;

public class DetalhePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_post);
        Intent intent = getIntent();
//        Parcelable prc = intent.getParcelableExtra("objTodo");
//        if (prc instanceof Todo) {
//
//        }
//        if (prc instanceof Pessoa) {
//
//        }
        Post post = intent.getParcelableExtra("objPost");
//        bind(post);

        TextView tv = findViewById(R.id.tvId);
        tv.setText(post.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(post.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(post.getTitle());
        tv = findViewById(R.id.tvBody);
        tv.setText(post.getBody());

    }
//    public void trocaLayout(View v) {
//        setContentView(R.layout.layout);
//        Intent intent = getIntent();
//        Post todo = intent.getParcelableExtra("objTodo");
//        bind(todo);
//
//    }
//    public void cbClick(View v) {
//        CheckBox cb = findViewById(R.id.cbCompleted);
//        Intent intent = getIntent();
//        Post todo = intent.getParcelableExtra("objTodo");
//        todo.setCompleted(cb.isChecked());
//    }
//    private void bind(Post obj) {
//        TextView tv = findViewById(R.id.tvId);
//        tv.setText(obj.getId()+"");
//        tv = findViewById(R.id.tvIdUser);
//        tv.setText(obj.getUserId()+"");
//        tv = findViewById(R.id.tvTitle);
//        tv.setText(obj.getTitle());
//        CheckBox cb = findViewById(R.id.cbCompleted);
//        cb.setChecked(obj.isCompleted());

//    }
}