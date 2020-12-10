package com.location.api.controller;

import com.location.api.dto.CityTemperatureDTO;
import com.location.api.service.TemperatureService;
import com.location.api.util.vo.EndpointVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Expose a rest webservice to obtain temperature information about a location
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
@Slf4j
@RestController
@RequestMapping(EndpointVO.VERSION_V1 + EndpointVO.RESOURCE_TEMPERATURE)
public class TemperatureController {

    private TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    /**
     * Service which receive a request with the name of a city in the world,
     * and return the temperature of the city in Celsius and Fahrenhei
     *
     * @param city city of the world
     */
    @GetMapping("/search")
    public List<CityTemperatureDTO> findTemperatureByCity(@RequestParam (required = true) String city){
        log.info("[Controller][findWeatherByCity]: [{}]", city);
        return temperatureService.findTempByCity(city);
    }

}
