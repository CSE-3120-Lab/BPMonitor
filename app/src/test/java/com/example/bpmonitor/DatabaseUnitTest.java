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



public class DatabaseUnitTest {
    /**
     * checks if a record is added successfully on database
     */
    @Test
    public void testAdd() {
        database dataBase = new database(RuntimeEnvironment.application);

        String sp = "95";
        String dp = "75";
        String bpm = "68";
        String date = "";
        String time = "";
        String notes = "sdf";

        boolean id = dataBase.insertuserdata(sp, dp, bpm, date, time, notes);

        assertTrue(dataBase.checkIfDataExists(id));

        myDatabaseHelper.close();
    }

}
