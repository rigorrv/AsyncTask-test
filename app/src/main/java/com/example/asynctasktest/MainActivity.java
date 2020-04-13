package com.example.asynctasktest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

public class MainActivity extends Activity{
    Button button;
    EditText user, pass;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Tas1().execute(user.getText().toString());
            }
        });
    }
    class Tas1 extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            button.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
            button.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("username", user.getText().toString());
            startActivity(intent);
        }

    }
}