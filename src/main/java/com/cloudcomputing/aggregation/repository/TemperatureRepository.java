package com.cloudcomputing.aggregation.repository;


import com.cloudcomputing.aggregation.model.TemperatureModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureRepository extends MongoRepository<TemperatureModel, String> {
    List<TemperatureModel> findAllBySensorId(String sensorId);
}
