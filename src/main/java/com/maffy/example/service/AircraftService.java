package com.maffy.example.service;

import com.maffy.example.model.Aircraft;
import com.maffy.example.utils.DummyData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/10/13
 * Time: 6:55 PM
 */
@Service
public class AircraftService {

    /**
     * Get the aircraft by id.
     *
     */
    public Aircraft getAircraft(Long id) {

        Aircraft aircraft = DummyData.getDefaultAircraft(id);

        return aircraft;
    }

    /**
     * Gets all aircraft.
     *
     */
    public List<Aircraft> getAllAircraft(){
        List<Aircraft> planes = DummyData.getListOfPlanes();

        return planes;
    }

    /**
     * Create an aircraft
     */
    public Aircraft createAircraft(Aircraft aircraft) {

        // not including a db with this so this is just a stub

        // setting timestamps
        aircraft.setDateCreated(new Date());
        aircraft.setLastUpdated(new Date());

        // id is harder to fake, so tests will provide one

        return aircraft;
    }

    public List<String> getAllTailNumbers() {
        List<String> result = new ArrayList<String>();
        for (Aircraft a : getAllAircraft()) {
             result.add(a.getTail());
        }
        return result;
    }

}
