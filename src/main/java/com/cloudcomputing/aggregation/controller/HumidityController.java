package com.cloudcomputing.aggregation.controller;

import com.cloudcomputing.aggregation.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/humidity")
public class HumidityController {

@Autowired
private HumidityService humidityService;

    @GetMapping("/humidityForPaprotka")
    public ResponseEntity<?> getTemperatureForPaprotka(){
        return new ResponseEntity<>(humidityService.getHumidityByPlantName("Paprotka"), HttpStatus.OK);
    }

    @GetMapping("/humidityForZamioculcas")
    public ResponseEntity<?> getHumidityZamioculcas(){
        return new ResponseEntity<>(humidityService.getHumidityByPlantName("Zamioculcas"), HttpStatus.OK);
    }

    @GetMapping("/humidityStaticsForPaprotka")
    public ResponseEntity<?> getHumidityStatisticsForPaprotka(){
        return new ResponseEntity<>(humidityService.getAverageHumidityByPlantName("Paprotka"), HttpStatus.OK);
    }
}
