package com.cloudcomputing.aggregation.dto;

import lombok.Builder;
import lombok.Data;

import java.util.DoubleSummaryStatistics;

@Builder
@Data
public class HumidityAverageDTO {
    private String name;
    private DoubleSummaryStatistics value;
}
