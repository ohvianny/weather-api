package com.location.api.feign.model;

import lombok.Data;

import java.util.Date;

@Data
public class ConsolidatedWeather {

    private Long id;
    private Date applicable_date;
    private double the_temp;

}
