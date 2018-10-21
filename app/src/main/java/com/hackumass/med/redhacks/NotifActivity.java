package com.hackumass.med.redhacks;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class NotifActivity extends AppCompatActivity {

    EditText alarm;
    int month,currentDay,year;
    long epochTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Alarms");
        alarm = findViewById(R.id.alarm);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent =  PendingIntent.getBroadcast(this,1,intent,0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,8,2);


        long currentTime = System.currentTimeMillis();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,currentTime + 5000,10000,pendingIntent);
        alarmManager.cancel(pendingIntent);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar newCalendar = Calendar.getInstance();
                month = newCalendar.get(Calendar.MONTH);
                year = newCalendar.get(Calendar.YEAR);
                currentDay=newCalendar.get(Calendar.DAY_OF_MONTH);
                showDatePicker(NotifActivity.this, year, month, currentDay);
            }
        });

    }

    private void showDatePicker(Context context, int initialYear, int initialMonth, int initialDay) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int year, int month, int day) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, day);
                        epochTime = calendar.getTime().getTime();
                        alarm.setText(day + "/" + (month + 1) + "/" + year);
                        NotifActivity.this.currentDay = day;
                        NotifActivity.this.month = month;
                        NotifActivity.this.year = year;
                    }
                }, initialYear, initialMonth, initialDay);
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
    }

}
