package com.cloudcomputing.aggregation.service;

import com.cloudcomputing.aggregation.dto.TemperatureDTO;
import com.cloudcomputing.aggregation.mapper.TemperatureMapper;
import com.cloudcomputing.aggregation.model.TemperatureModel;
import com.cloudcomputing.aggregation.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureService {
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private TemperatureMapper temperatureMapper;

    public List<TemperatureDTO> getTemperatureByPlantName(String name){
            return temperatureRepository.findAllBySensorId(name)
                    .stream()
                    .map(temperatureModel ->temperatureMapper.mapTemperatureModelToTemperatureDTO(temperatureModel))
                    .collect(Collectors.toList());
    }

}
