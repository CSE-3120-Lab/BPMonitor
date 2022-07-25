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

    /**
     * initialize database with context
     * @param context
     * initialize context
     */
    public database(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    /**
     * onCreate of database class this method will be
     * executed and connect system with sqlite database
     * @param DB
     * this uses SQLiteDatabase type as parameter
     */
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Userdetails(sp TEXT, dp TEXT, bpm TEXT, date TEXT, time TEXT, notes TEXT)");
    }

    /**
     * this method will drop database table
     * @param DB
     * this is a SQLiteDatabase type parameter
     * @param i
     * @param ii
     */
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    /**
     * insert record into sqlite database
     * @param sp
     * Systolic data
     * @param dp
     * Diastolic data
     * @param bpm
     * Pulse data
     * @param date
     * the Date when value was inserted
     * @param time
     * the time when value was inserted
     * @param notes
     * Notes of each record
     * @return
     * return boolean value to check
     * data is inserted
     */

    public Boolean insertuserdata(String sp,String dp,String bpm,String date,String time,String notes)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
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
    public long checkuserdata(String sp,String dp,String bpm,String date,String time,String notes)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sp",sp);
        contentValues.put("dp",dp);
        contentValues.put("bpm",bpm);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("notes",notes);
        long result=DB.insert("Userdetails",null,contentValues);
        return result;
    }
    /**
     * check on a particular id if data exists or not
     * on sqlite database
     * @param sp
     * checks sp for data in database
     * @param dp
     * checks dp for data in database
     * @param bpm
     * and checks sp for data in database
     * @return
     * true if data exists or false or no existence of data on
     * that id
     */
    public boolean checkIfDataExists(String sp, String dp, String bpm) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String Query = "Select * from Userdetails where sp="+sp+" and dp= "+dp+" and bpm = " + bpm;
        Cursor cursor = sqLiteDatabase.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    /**
     * Used to return values of database
     * @return
     * returns all data from database
     */
    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from Userdetails", null);
        return cursor;
    }

    /**
     * delete record from sqlite database
     * @param sp
     * systolic data of the row you want to delete
     * @param dp
     * diastolic data of the row you want to delete
     * @param bpm
     * bpm of the row you want to delete
     */
    public void deleteData(String sp,String dp,String bpm)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        String whereClause= "sp=? AND dp=? AND bpm=?";
        String whereArgs[]={sp,dp,bpm};
        DB.delete("Userdetails",whereClause,whereArgs);
    }

    /**
     * used to update data on database
     * @param checkSP
     * systolic data of the row you want to update
     * @param checkDP
     * diastolic data of the row you want to update
     * @param checkBPM
     * bpm data of the row you want to update
     * @param sp
     * systolic data of the row you want to update
     * @param dp
     * diastolic data of the row you want to update
     * @param bpm
     * bpm of the row you want to update
     * @param date
     * date of the row you want to update
     * @param time
     * time of the row you want to update
     * @param notes
     * notes of the row you want to update
     */
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
