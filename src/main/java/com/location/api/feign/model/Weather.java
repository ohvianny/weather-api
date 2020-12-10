package com.location.api.feign.model;

import lombok.Data;

import java.util.List;

@Data
public class Weather extends WOEID{

    private String timezone;
    private List<ConsolidatedWeather> consolidated_weather;

}
