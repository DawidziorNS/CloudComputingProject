package com.cloudcomputing.aggregation.controller;

import com.cloudcomputing.aggregation.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {
@Autowired
   private TemperatureService temperatureService;

    @GetMapping("/temperatureForPaprotka")
    public ResponseEntity<?> getTemperatureForPaprotka(){
        return new ResponseEntity<>(temperatureService.getTemperatureByPlantName("Paprotka"), HttpStatus.OK);
    }


    @GetMapping("/temperatureForZamioculcas")
    public ResponseEntity<?> getTemperatureForZamioculcas(){
        return new ResponseEntity<>(temperatureService.getTemperatureByPlantName("Zamioculcas"), HttpStatus.OK);
    }

}
