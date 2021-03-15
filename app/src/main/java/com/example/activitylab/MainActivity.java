package com.example.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvoncreate;
    private TextView tvonstart;
    private TextView tvrestart;
    private TextView tvresume;
    private int create,start,restart,resume;
    private Button btnsecondactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvoncreate=findViewById(R.id.tvcreate);
        tvonstart=findViewById(R.id.tvStart);
        tvrestart=findViewById(R.id.tvrestart);
        tvresume=findViewById(R.id.tvResume);
        btnsecondactivity=findViewById(R.id.btnmove);
        create++;
        tvoncreate.setText("onCreate() calls : "+create);
        btnsecondactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        resume++;
        Log.i("lifecycle","On Resume called "+resume);
        tvresume.setText("onResume calls():"+resume);
    }

    @Override
    protected void onStart() {
        super.onStart();
         start++;
        Log.i("lifecycle","On Start called "+start);
         tvonstart.setText("onstart calls():"+start);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       restart++;
        Log.i("lifecycle","On ReStart called "+restart);
       tvrestart.setText("onRestart call():"+restart);
    }
}