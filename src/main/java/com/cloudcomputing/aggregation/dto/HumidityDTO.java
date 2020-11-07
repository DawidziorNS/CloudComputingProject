package com.cloudcomputing.aggregation.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class HumidityDTO {
    private String sensorId;
    private LocalDateTime date;
    private Long humidity;
}
