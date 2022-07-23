package com.example.bpmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class popupActiviy extends AppCompatActivity {
    database DB=new database(this);
    EditText spEdit,dpEdit,bpmEdit,dateEdit,timeEdit,notesEdit;
    Button buttonUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        String sp=getIntent().getStringExtra("spEdit");
        String dp=getIntent().getStringExtra("dpEdit");
        String bpm=getIntent().getStringExtra("bpmEdit");
        String date=getIntent().getStringExtra("dateEdit");
        String time=getIntent().getStringExtra("timeEdit");
        String notes=getIntent().getStringExtra("notesEdit");

        spEdit=findViewById(R.id.spUpdate);
        dpEdit=findViewById(R.id.dpUpdate);
        bpmEdit=findViewById(R.id.bpmUpdate);
        dateEdit=findViewById(R.id.dateUpdate);
        timeEdit=findViewById(R.id.timeUpdate);
        notesEdit=findViewById(R.id.notesUpdate);

        spEdit.setText(sp);
        dpEdit.setText(dp);
        bpmEdit.setText(bpm);
        dateEdit.setText(date);
        timeEdit.setText(time);
        notesEdit.setText(notes);

        buttonUpdate=findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.updateData(sp,dp,bpm,spEdit.getText().toString(),dpEdit.getText().toString(),bpmEdit.getText().toString(),dateEdit.getText().toString(),timeEdit.getText().toString(),notesEdit.getText().toString());
                Toast.makeText(popupActiviy.this,"updated",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(popupActiviy.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}