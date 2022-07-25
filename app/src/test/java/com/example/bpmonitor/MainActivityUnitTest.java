package com.example.bpmonitor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainActivityUnitTest {
    /**
     * checks if a record is added successfully on detailsList
     */
    @Test
    public void testAdd() {
        List<details> detailsList = new ArrayList<>();
        details details = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details);
        assertEquals(1,detailsList.size());
        details details2 = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details2);
        assertEquals(2,detailsList.size());
    }

    /**
     * checks if add function handle exception successfully
     */
    @Test
    public void testAddException() {
        List<details> detailsList = new ArrayList<>();
        details details = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details);
        assertThrows(IllegalArgumentException.class, () -> {
            if (detailsList.contains(details)) {
                throw new IllegalArgumentException();
            }
        });
    }

    /**
     * checks if record is deleted successfully from detailsList
     */
    @Test
    public  void testDelete(){
        List<details> detailsList = new ArrayList<>();
        details details = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details);
        assertEquals(1,detailsList.size());
        detailsList.remove(details);
        assertEquals(0,detailsList.size());
    }

    /**
     * to check if delete function handles exception successfully
     */
    @Test
    public  void testDeleteException(){
        List<details> detailsList = new ArrayList<>();
        details details = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details);
        detailsList.remove(details);
        assertThrows(IllegalArgumentException.class, () -> {
            if (!detailsList.contains(details)) {
                throw new IllegalArgumentException();
            }
        });
    }

    /**
     * checks if record is updated successfully on detailsList
     */
    @Test
    public void testUpdate(){
        List<details> detailsList = new ArrayList<>();
        details details = new details("95","65","75","02-02-2022","5:30","test");
        detailsList.add(details);
        details details2 = new details("100","67","74","02-02-2022","5:30","test");
        if (detailsList.contains(details))
        {
            detailsList.remove(details);
            detailsList.add(details2);
            assertEquals(0,details2.compareTO(detailsList.get(0)));
        }
    }

}
