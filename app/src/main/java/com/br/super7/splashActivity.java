package com.br.super7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Thread thread = new Thread() {
            public  void run(){
                try{
                    sleep(1500);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent mainAct=new Intent(splashActivity.this, MainActivity.class);
                    startActivity(mainAct);
                    finish();
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

}