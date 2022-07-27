package com.example.bpmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * This is MainActivity class of the application
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<details> detailsList;
    database DB;
    MyAdapter adapter;

    /**
     * this method will add fragment using recyclerview
     * @param savedInstanceState
     * takes a bundle type parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB= new database(this);
        detailsList =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,detailsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


        //Plus button
        FloatingActionButton buttonPlus= findViewById(R.id.buttonCreate);
        buttonPlus.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,InputActivity.class)));

    }

    //overriding onResume to refresh the data after an update

    /**
     * this will refresh data after an update
     */
    @Override
    public void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
        DB= new database(this);
        detailsList =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,detailsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


        //Plus button
        FloatingActionButton buttonPlus= findViewById(R.id.buttonCreate);
        buttonPlus.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,InputActivity.class)));
    }

    /**
     * This will display the existing data
     */
    private void displaydata() {
        Cursor cursor=DB.getdata();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                details details = new details(cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getString(6));
                detailsList.add(details);
                cursor.moveToNext();
            }
        }
        cursor.close();
    }
}