package com.example.bpmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CardView cardView;
    List<details> detailsList;
    database DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB= new database(this);
        detailsList =new ArrayList<>();
        /*sp=new ArrayList<>();
        dp=new ArrayList<>();
        bpm=new ArrayList<>();
        date=new ArrayList<>();
        time=new ArrayList<>();
        notes=new ArrayList<>();*/

        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,detailsList/*sp,dp,bpm,date,time,notes*/);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


        //Plus button
        FloatingActionButton buttonPlus= findViewById(R.id.buttonCreate);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InputActivity.class));
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
        DB= new database(this);
        detailsList =new ArrayList<>();
        /*sp=new ArrayList<>();
        dp=new ArrayList<>();
        bpm=new ArrayList<>();
        date=new ArrayList<>();
        time=new ArrayList<>();
        notes=new ArrayList<>();*/
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,detailsList/*sp,dp,bpm,date,time,notes*/);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        //Plus button
        FloatingActionButton buttonPlus= findViewById(R.id.buttonCreate);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InputActivity.class));
            }
        });
    }

    private void displaydata() {
        Cursor cursor=DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(MainActivity.this,"No Entries",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                details details = new details(cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getString(6));
                detailsList.add(details);
                /*sp.add(cursor.getString(1));
                dp.add(cursor.getString(2));
                bpm.add(cursor.getString(3));
                date.add(cursor.getString(4));
                time.add(cursor.getString(5));
                notes.add(cursor.getString(6));*/
            }
        }
    }
}