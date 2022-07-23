package com.example.bpmonitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {

    List<details> detailsList=new ArrayList<>();

    public database(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Userdetails(sp TEXT, dp TEXT, bpm TEXT, date TEXT, time TEXT, notes TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String sp,String dp,String bpm,String date,String time,String notes)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id","");
        contentValues.put("sp",sp);
        contentValues.put("dp",dp);
        contentValues.put("bpm",bpm);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("notes",notes);
        long result=DB.insert("Userdetails",null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from Userdetails", null);
        //Cursor cursor=DB.rawQuery("select sp,dp,bpm,strftime('%d-%m-%Y',date),time,notes from Userdetails", null);
        return cursor;
    }
    public void deleteData(String sp,String dp,String bpm)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        String whereClause= "sp=? AND dp=? AND bpm=?";
        String whereArgs[]={sp,dp,bpm};
        DB.delete("Userdetails",whereClause,whereArgs);
    }
    public void updateData(String checkSP,String checkDP,String checkBPM,String sp,String dp,String bpm,String date,String time,String notes)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sp",sp);
        contentValues.put("dp",dp);
        contentValues.put("bpm",bpm);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("notes",notes);
        String whereClause= "sp=? AND dp=? AND bpm=?";
        String whereArgs[]={checkSP,checkDP,checkBPM};
        DB.update("Userdetails", contentValues, whereClause, whereArgs);
    }
}
