package com.location.api.feign.model;

import lombok.Data;

@Data
public class WOEID {

    private String title;
    private String location_type;
    private Long woeid;
    private String latt_long;

}
