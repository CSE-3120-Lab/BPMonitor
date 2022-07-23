package com.example.bpmonitor;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ShowActivity extends AppCompatActivity {
    database DB=new database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //getIncomingIntent();

            String sp=getIntent().getStringExtra("spLocation");
            String dp=getIntent().getStringExtra("dpLocation");
            String bpm=getIntent().getStringExtra("bpmLocation");
            String date=getIntent().getStringExtra("dateLocation");
            String time=getIntent().getStringExtra("timeLocation");
            String notes=getIntent().getStringExtra("notesLocation");

            setDetails(sp,dp,bpm,date,time,notes);

        Button buttonEdit=findViewById(R.id.buttonEdit);
        Button buttonDelete=findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sp=findViewById(R.id.spShow2);
                TextView dp=findViewById(R.id.dpShow2);
                TextView bpm=findViewById(R.id.bpmShow2);
                DB.deleteData(sp.getText().toString(),dp.getText().toString(),bpm.getText().toString());
                Toast.makeText(ShowActivity.this,"deleted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this,popupActiviy.class);
                intent.putExtra("spEdit",sp);
                intent.putExtra("dpEdit",dp);
                intent.putExtra("bpmEdit",bpm);
                intent.putExtra("dateEdit",date);
                intent.putExtra("timeEdit",date);
                intent.putExtra("notesEdit",notes);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        setContentView(R.layout.activity_show);

        //getIncomingIntent();

        String sp=getIntent().getStringExtra("spLocation");
        String dp=getIntent().getStringExtra("dpLocation");
        String bpm=getIntent().getStringExtra("bpmLocation");
        String date=getIntent().getStringExtra("dateLocation");
        String time=getIntent().getStringExtra("timeLocation");
        String notes=getIntent().getStringExtra("notesLocation");

        setDetails(sp,dp,bpm,date,time,notes);

        Button buttonEdit=findViewById(R.id.buttonEdit);
        Button buttonDelete=findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sp=findViewById(R.id.spShow2);
                TextView dp=findViewById(R.id.dpShow2);
                TextView bpm=findViewById(R.id.bpmShow2);
                DB.deleteData(sp.getText().toString(),dp.getText().toString(),bpm.getText().toString());
                Toast.makeText(ShowActivity.this,"deleted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this,popupActiviy.class);
                intent.putExtra("spEdit",sp);
                intent.putExtra("dpEdit",dp);
                intent.putExtra("bpmEdit",bpm);
                intent.putExtra("dateEdit",date);
                intent.putExtra("timeEdit",date);
                intent.putExtra("notesEdit",notes);
                startActivity(intent);
                finish();
            }
        });

    }
   /* @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setContentView(R.layout.activity_show);

        getIncomingIntent();
    }*/
    /*private void getIncomingIntent(){
        if(getIntent().hasExtra("spLocation")){
            String sp=getIntent().getStringExtra("spLocation");
            String dp=getIntent().getStringExtra("dpLocation");
            String bpm=getIntent().getStringExtra("bpmLocation");
            String date=getIntent().getStringExtra("dateLocation");
            String time=getIntent().getStringExtra("timeLocation");
            String notes=getIntent().getStringExtra("notesLocation");

            setDetails(sp,dp,bpm,date,time,notes);
        }
    }*/

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
   /* private void popup(){
        sp =findViewById(R.id.spUpdate);
        dp=findViewById(R.id.dpUpdate);
        bpm=findViewById(R.id.bpmUpdate);
        date=findViewById(R.id.dateUpdate);
        time=findViewById(R.id.timeUpdate);
        notes=findViewById(R.id.notesUpdate);
        buttonUpdate = findViewById(R.id.buttonUpdate);
    }*/
}