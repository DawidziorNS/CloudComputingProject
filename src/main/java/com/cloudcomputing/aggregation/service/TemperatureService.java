package com.cloudcomputing.aggregation.service;

import com.cloudcomputing.aggregation.model.TemperatureModel;
import com.cloudcomputing.aggregation.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureRepository temperatureRepository;

    public List<TemperatureModel> getDataFromPaprotka(String name){
        return temperatureRepository.findAllBySensorId(name);
    }

}
