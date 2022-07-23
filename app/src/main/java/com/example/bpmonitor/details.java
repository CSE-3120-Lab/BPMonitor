package com.example.bpmonitor;

public class details {
    private String sp;
    private String dd;
    private String bpm;
    private String notes;
    private String date;
    private String time;

    public details(String sp, String dd, String bpm, String time, String date, String notes) {
        this.sp = sp;
        this.dd = dd;
        this.bpm = bpm;
        this.notes = notes;
        this.date = date;
        this.time = time;
    }

    public String getSp() {
        return sp;
    }

    public String getDd() {
        return dd;
    }

    public String getBpm() {
        return bpm;
    }

    public String getNotes() {
        return notes;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int compareTO(details o){
        return this.sp.compareTo(sp);
    }
}
