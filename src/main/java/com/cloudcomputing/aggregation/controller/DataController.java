package com.cloudcomputing.aggregation.controller;

import com.cloudcomputing.aggregation.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DataController {
@Autowired
   private TemperatureService temperatureService;

    @GetMapping("/test")
    public ResponseEntity<?> getData(){
        return new ResponseEntity<>(temperatureService.getDataFromPaprotka("Zamioculcas"), HttpStatus.OK);
    }

}
