package com.example.bpmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        getIncomingIntent();

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setContentView(R.layout.activity_show);

        getIncomingIntent();
    }
    private void getIncomingIntent(){
        if(getIntent().hasExtra("spLocation")){
            String sp=getIntent().getStringExtra("spLocation");
            String dp=getIntent().getStringExtra("dpLocation");
            String bpm=getIntent().getStringExtra("bpmLocation");
            String date=getIntent().getStringExtra("dateLocation");
            String time=getIntent().getStringExtra("timeLocation");
            String notes=getIntent().getStringExtra("notesLocation");

            setDetails(sp,dp,bpm,date,time,notes);
        }
    }

    private void setDetails(String sp,String dp,String bpm,String date,String time,String notes){
        TextView spShow=findViewById(R.id.spShow2);
        TextView dpShow=findViewById(R.id.dpShow2);
        TextView bpmShow=findViewById(R.id.bpmShow2);
        TextView dateShow=findViewById(R.id.dateShow2);
        TextView timeShow=findViewById(R.id.timeShow2);
        TextView notesShow=findViewById(R.id.notesShow2);

        spShow.setText(sp);
        dpShow.setText(dp);
        bpmShow.setText(bpm);
        dateShow.setText(date);
        timeShow.setText(time);
        notesShow.setText(notes);

    }
}