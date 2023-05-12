package com.mygdx.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class splashscreen extends AppCompatActivity {

    //criação de uma instancia da classe Timer
    private final Timer timer = new Timer();
    TimerTask timerTask;

    //define o uso do layout activity_hello.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //executará a main activity quando o tempo limite for atingido
        timerTask = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gotoMyGdxGame();
                    }


                });

            }


        };

        //adiciona um delay de 3s para a execução da tarefa
        timer.schedule(timerTask, 100000000);




    }

    //passado os 3s, inicia a main activity
    private void gotoMyGdxGame() {

        Intent intent = new Intent(getApplicationContext(), MyGdxGame.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


}