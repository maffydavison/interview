package com.maffy.example.service;

import com.maffy.example.model.Aircraft;
import com.maffy.example.utils.DummyData;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/11/13
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class AircraftServiceTest extends TestCase {

    private AircraftService service = new AircraftService();
    private Long id = 9L;

    public void testGetAircraft() throws Exception {
        Aircraft aircraft = service.getAircraft(new Long("1"));
        assertNotNull(aircraft);

    }

    public void testGetAllAircraft() throws Exception {
        List<Aircraft> planes = service.getAllAircraft();
        assertNotNull(planes);
        assertNotNull(planes.get(3));
    }

    public void testCreateAircraft() throws Exception {
        Aircraft aircraft = DummyData.getDefaultAircraft(id);
        Aircraft result = service.createAircraft(aircraft);
        assertNotNull(result);
        assert result.getId().equals(id);
    }

    public void testGetAllTailNumbers() throws Exception {
        List<String> result = service.getAllTailNumbers();
        assert !result.isEmpty();
        assert result.size() == 4;
        assert result.contains("N1231");
        assert result.contains("N1232");
        assert result.contains("N1233");
        assert result.contains("N1234");
    }
}
