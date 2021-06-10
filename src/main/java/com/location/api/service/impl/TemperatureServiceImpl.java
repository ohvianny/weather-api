package com.location.api.service.impl;

import com.location.api.dto.CityTemperatureDTO;
import com.location.api.feign.WeatherClient;
import com.location.api.feign.model.WOEID;
import com.location.api.feign.model.Weather;
import com.location.api.service.TemperatureService;
import com.location.api.util.converter.WeatherToCityTempDTOConverter;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to obtain temperature of a location
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
@Slf4j
@Service
public class TemperatureServiceImpl implements TemperatureService {

    private WeatherClient weatherClient;

    public TemperatureServiceImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public List<CityTemperatureDTO> findTempByCity(String city) {
        log.info("[Service][findTempByCity]: [{}]", city);
        List<Weather> weatherList = new ArrayList<>();
        try {
            List<WOEID> woeidList = weatherClient.findWOEIDByCity(city);
            if(!woeidList.isEmpty()) {
                log.info("[Service][findWeatherByWOEIDs] size: [{}]", woeidList.size());
                try {
                    for (WOEID woeid : woeidList) {
                        Weather weather = weatherClient.findWeatherByWOEID(woeid.getWoeid());
                        weatherList.add(weather);
                    }
                    return weatherList
                            .stream()
                            .map(new WeatherToCityTempDTOConverter()::convert)
                            .collect(Collectors.toList());
                } catch (FeignException f) {
                    log.error("[Service][findWeatherByWOEIDs]: ", f);
                    return null;
                }
            }
        } catch (FeignException f) {
            log.error("[Service][findTempByCity]: [{}] + [{}]", city, f);
            return null;
        }
        return null;
    }

}
