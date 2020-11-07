package com.cloudcomputing.aggregation.mapper;

import com.cloudcomputing.aggregation.dto.TemperatureDTO;
import com.cloudcomputing.aggregation.model.TemperatureModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TemperatureMapper {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public TemperatureDTO mapTemperatureModelToTemperatureDTO(TemperatureModel temperatureModel){
    return TemperatureDTO.builder()
            .sensorId(temperatureModel.getSensorId())
            .temp(temperatureModel.getTemp())
            .date(LocalDateTime.parse(temperatureModel.getDate(), formatter))
            .build();
}
}
