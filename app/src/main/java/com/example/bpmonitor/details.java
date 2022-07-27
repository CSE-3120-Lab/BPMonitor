package com.example.bpmonitor;

/**
 * this class stores all the data
 */
public class details {
    private String sp;
    private String dd;
    private String bpm;
    private String notes;
    private String date;
    private String time;

    /**
     * constructor of the details class
     * @param sp
     * Systolic data
     * @param dd
     * Diastolic data
     * @param bpm
     * Pulse data
     * @param date
     * the Date when value was inserted
     * @param time
     * the time when value was inserted
     * @param notes
     * Notes of each record
     */
    public details(String sp, String dd, String bpm, String date, String time, String notes) {
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
