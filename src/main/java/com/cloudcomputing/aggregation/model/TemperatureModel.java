package com.cloudcomputing.aggregation.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temperature")
public class TemperatureModel {
private String sensorId;
private String date;
private Long temp;
}
