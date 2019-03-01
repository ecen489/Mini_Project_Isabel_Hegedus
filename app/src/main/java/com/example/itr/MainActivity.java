package com.example.itr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.TimerTask;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    double[] inputData ={ 99.4, 99.2, 99.0, 98.7, 98.4, 98.1, 97.9, 97.8, 97.6, 97.3, 97.1, 96.9, 96.7, 96.7, 96.5,};
    int index=0;
    Timer timer;

    public void timer(View V){
        sendElement(inputData[index]);
        index++;
        if(index>=inputData.length){
            index=0;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer= new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                sendElement(inputData[index]);
                if(inputData[index]<=97.2){
                    triggerW();
                    cancel();
                }

                index++;
                if(index>=inputData.length){
                    cancel();

                }


            }
        }, 0, 1000);
    }

    public void sendElement(double d ){
        Graph graph1 = (Graph) getSupportFragmentManager().findFragmentById(R.id.graphv);
        graph1.receiveElement(d);

        tempview temp1 = (tempview) getSupportFragmentManager().findFragmentById(R.id.temp);
        temp1.receiveElement(d);
    }


    public void triggerW(){
        Intent in = new Intent(getBaseContext(),Warning.class);
        startActivity(in);
    }

    public void onResume(){
        super.onResume();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                sendElement(inputData[index]);
                if(inputData[index]<=97.2){
                    triggerW();
                    cancel();
                }

                index++;
                if(index>=inputData.length){
                    cancel();

                }


            }
        }, 0, 1000);

    }

}
