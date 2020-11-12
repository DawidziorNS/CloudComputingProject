package com.cloudcomputing.aggregation.service;

import com.cloudcomputing.aggregation.dto.HumidityAverageDTO;
import com.cloudcomputing.aggregation.dto.HumidityDTO;
import com.cloudcomputing.aggregation.mapper.HumidityMapper;
import com.cloudcomputing.aggregation.model.HumidityModel;
import com.cloudcomputing.aggregation.repository.HumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumidityService {
    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private HumidityMapper humidityMapper;

    public List<HumidityDTO> getHumidityByPlantName(String name) {
        return humidityRepository.findAllBySensorId(name)
                .stream()
                .map(humidityModel ->humidityMapper.mapTemperatureModelToTemperatureDTO(humidityModel))
                .collect(Collectors.toList());
    }

    public HumidityAverageDTO getAverageHumidityByPlantName(String name){
        DoubleSummaryStatistics doubleSummaryStatistics=getHumidityByPlantName(name)
                .stream()
                //.filter(p-> p.getDate().isAfter(LocalDateTime.now().minus(1, ChronoUnit.DAYS)))
                .mapToDouble(x->x.getHumidity())
                .summaryStatistics();

        return HumidityAverageDTO.builder()
                .name(name)
                .value(doubleSummaryStatistics)
                .build();
    }

}
