package com.cloudcomputing.aggregation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("humidity")
@Data
public class HumidityModel {
    private String sensorId;
    private String date;
    private Long humidity;
}
