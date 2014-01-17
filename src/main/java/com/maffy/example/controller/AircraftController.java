package com.maffy.example.controller;

import com.maffy.example.model.Aircraft;
import com.maffy.example.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/11/13
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("api")
public class AircraftController {


    AircraftService aircraftService;

    @RequestMapping("aircraft/{id}")
    @ResponseBody
    public Aircraft getById(@PathVariable Long id) {
        return aircraftService.getAircraft(id);
    }

    @RequestMapping(value = "aircraft", method = RequestMethod.GET)
    @ResponseBody
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @RequestMapping(value = "aircraft/tail", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllTailNumbers() {
        return aircraftService.getAllTailNumbers();
    }

    @RequestMapping(value = "aircraft", method = RequestMethod.PUT)
    @ResponseBody
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

}
