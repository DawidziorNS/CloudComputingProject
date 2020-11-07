package com.cloudcomputing.aggregation.mapper;

import com.cloudcomputing.aggregation.dto.HumidityDTO;
import com.cloudcomputing.aggregation.model.HumidityModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class HumidityMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public HumidityDTO mapTemperatureModelToTemperatureDTO(HumidityModel humidityModel){
        return HumidityDTO.builder()
                .sensorId(humidityModel.getSensorId())
                .humidity(humidityModel.getHumidity())
                .date(LocalDateTime.parse(humidityModel.getDate(), formatter))
                .build();
    }
}
