package com.example.bpmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    EditText sp,dp,bpm,date,time,notes;
    Button buttonAdd,buttonCancel;
    database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        //actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // providing title for the ActionBar
        actionBar.setTitle("New Measurements");

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp=findViewById(R.id.systolicInput);
        dp=findViewById(R.id.diastolicInput);
        bpm=findViewById(R.id.bpmInput);
        date=findViewById(R.id.dateInput);
        time=findViewById(R.id.timeInput);
        notes=findViewById(R.id.notesInput);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonCancel=findViewById(R.id.buttonCancel);

        DB=new database(this);

        //cancel button
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //add button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spIn=sp.getText().toString();
                String dpIn=dp.getText().toString();
                String bpmIn=bpm.getText().toString();
                 String dateIn=date.getText().toString();
                 String timeIn=time.getText().toString();
                 String notesIn=notes.getText().toString();

                 Boolean checkinsertdata=DB.insertuserdata(spIn,dpIn,bpmIn,dateIn,timeIn,notesIn);
                 if (checkinsertdata==true)
                 {
                     Toast.makeText(InputActivity.this,"inserted",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(InputActivity.this,"not inserted",Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }






    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}