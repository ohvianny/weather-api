package com.location.api.feign;

import com.location.api.feign.model.WOEID;
import com.location.api.feign.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface WeatherClient {

    @GetMapping("/api/location/search/?query={city}")
    List<WOEID> findWOEIDByCity(@PathVariable("city") String city);

    @GetMapping("/api/location/{woeid}")
    Weather findWeatherByWOEID(@PathVariable("woeid") Long woeid);

}
