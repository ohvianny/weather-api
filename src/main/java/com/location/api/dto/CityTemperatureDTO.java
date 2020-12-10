package com.location.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityTemperatureDTO {

    private String title;
    private String location_type;
    private Long woeid;
    private String latt_long;
    private String timezone;
    private Date applicable_date;
    private double temp_celsius;
    private double temp_fahrenheit;

}
