package com.maffy.example.utils;

import com.maffy.example.model.Aircraft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/10/13
 * Time: 7:02 PM
 */
public class DummyData {

    public static Aircraft getDefaultAircraft(Long id) {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(id);
        aircraft.setModel("747b");
        aircraft.setTail("N123" + id.toString());
        aircraft.setNose("N12JT" + id.toString());

        aircraft.setDateCreated(new Date());
        aircraft.setLastUpdated(new Date());
        return aircraft;

    }

    public static List<Aircraft> getListOfPlanes() {

        List<Aircraft> planes = new ArrayList<Aircraft>();
        for (long i = 1; i < 5 ; i++){
            Aircraft aircraft = DummyData.getDefaultAircraft(i);
            planes.add(aircraft);
        }

        return planes;
    }
}
