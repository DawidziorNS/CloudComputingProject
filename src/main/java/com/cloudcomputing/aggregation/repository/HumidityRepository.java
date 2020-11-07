package com.cloudcomputing.aggregation.repository;

import com.cloudcomputing.aggregation.model.HumidityModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidityRepository extends MongoRepository<HumidityModel, String> {
    List<HumidityModel> findAllBySensorId(String sensorId);

}
