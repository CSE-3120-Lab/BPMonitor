package com.example.bpmonitor;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DatabaseUnitTest class for unit testing on Database insertion, deletion or update
 */
@RunWith(RobolectricTestRunner.class)
public class DatabaseUnitTest {
    /**
     * checks if a record is added successfully on database
     */
    @Test
    public void testAdd() {
        database dataBase = new database(RuntimeEnvironment.application);

        String sp = "120";
        String dp = "72";
        String bpm = "67";
        String date = "02-02-2022";
        String time = "05:14";
        String notes = "after running";

        long result = dataBase.checkuserdata(sp, dp, bpm, date, time, notes);

        assertTrue(dataBase.checkIfDataExists(sp,dp,bpm));

        dataBase.close();
    }
    /**
     * checks if a record is deleted successfully on database
     */
    @Test
    public void testDelete() {
        database dataBase = new database(RuntimeEnvironment.application);

        String sp = "120";
        String dp = "72";
        String bpm = "67";
        String date = "02-02-2022";
        String time = "05:14";
        String notes = "after running";

        long result = dataBase.checkuserdata(sp, dp, bpm, date, time, notes);

        dataBase.deleteData(sp, dp, bpm);
        assertFalse(dataBase.checkIfDataExists(sp,dp,bpm));

        dataBase.close();
    }

    /**
     * checks if update on database is successful
     */
    @Test
    public void testUpdate() {
        database dataBase = new database(RuntimeEnvironment.application);

        String sp = "120";
        String dp = "72";
        String bpm = "67";
        String date = "02-02-2022";
        String time = "05:14";
        String notes = "after running";

        long result = dataBase.checkuserdata(sp, dp, bpm, date, time, notes);

        String sp1 = "115";
        String dp1 = "75";
        String bpm1 = "55";
        String date1 = "03-02-2022";
        String time1 = "04:15";
        String notes1 = "after swimming";

        dataBase.updateData(sp, dp, bpm, sp1, dp1, bpm1, date1, time1, notes1);

        assertTrue(dataBase.checkIfDataExists(sp1,dp1,bpm1));

        dataBase.close();
    }

}


