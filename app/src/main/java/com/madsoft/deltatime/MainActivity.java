package com.madsoft.deltatime;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Configuration;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public TextView maintext,countdown;
    String prestavka;
    public static String textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintext =  findViewById(R.id.MainText);
        countdown = findViewById(R.id.Countdown);
        prestavka = "Je přestávka!";

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        if(metrics.densityDpi < 350){
            maintext.setTextSize(60);
            countdown.setTextSize(34);
        }


        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                if (test != null) {
//                                    test.setText();
//                                }


                                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                                String currentDateAndTime = sdf.format(new Date());
                                maintext.setText(currentDateAndTime);
                                textCounter = currentDateAndTime;

                                Date currentTime = Calendar.getInstance().getTime();
                                int seconds = currentTime.getSeconds();
                                int minutes = currentTime.getMinutes();
                                int hours = currentTime.getHours();
                                int day = currentTime.getDay();
                                int month = currentTime.getMonth();


                                if (month == 6 || month == 7){
                                    countdown.setText("Jsou velké prázdniny.");
                                }
                                else if (day == 0 || day == 6){
                                    countdown.setText("Je víkend!");
                                }
                                else if (hours < 8){
                                    int EndHour = 7 - hours;
                                    int EndMinutes = 59 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Do začátku školy:\n" + EndHour + ":" + CalcSec(EndMinutes) + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 8 && minutes >= 0 && minutes < 45){
                                    int EndMinutes = 44 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 8 && minutes >= 45 && minutes < 50){
                                    int EndMinutes = 49 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 8 && minutes >= 50) || (hours == 9 && minutes < 35)){
                                    int EndHour = 9 - hours;
                                    int EndMinutes = 34 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 9 && minutes < 50){
                                    int EndMinutes = 49 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 9) || (hours == 10 && minutes < 35)){
                                    int EndHour = 10 - hours;
                                    int EndMinutes = 34 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 10 && minutes < 40){
                                    int EndMinutes = 39 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 10) || (hours == 11 && minutes < 25)){
                                    int EndHour = 11 - hours;
                                    int EndMinutes = 24 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 11 && minutes < 35){
                                    int EndMinutes = 34 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 11) || (hours == 12 && minutes < 20)){
                                    int EndHour = 12 - hours;
                                    int EndMinutes = 19 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 12 && minutes < 25){
                                    int EndMinutes = 24 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 12) || (hours == 13 && minutes < 10)){
                                    int EndHour = 13 - hours;
                                    int EndMinutes = 9 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 13 && minutes < 15){
                                    int EndMinutes = 14 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText("Přestávka končí za: " + EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 13)){
                                    int EndMinutes = 59 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if (hours == 14 && minutes < 45){
                                    int EndMinutes = 44 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else if ((hours == 14) || (hours == 15 && minutes < 30)){
                                    int EndHour = 15 - hours;
                                    int EndMinutes = 29 - minutes;
                                    int EndSeconds = 59 - seconds;
                                    if (EndHour == 1){
                                        EndMinutes += 60;
                                    }
                                    countdown.setText(EndMinutes + ":" + CalcSec(EndSeconds) + EndSeconds);
                                }
                                else{
                                    countdown.setText("Škola už skončila");
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

   String CalcSec(int sekunda){
       if (sekunda < 10){
           return "0";
       }
       else{
           return "";
       }
   }

   /*public void Notification(String text){
       NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
               .setSmallIcon(R.drawable.small)
               .setContentTitle(getString(R.string.app_name))
               .setContentText(text);
       Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       mBuilder.setSound(alarmSound);
       NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
       mNotificationManager.notify(001, mBuilder.build());
   }*/
}
