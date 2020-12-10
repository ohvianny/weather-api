package com.location.api.service;

import com.location.api.dto.CityTemperatureDTO;

import java.util.List;

/**
 * Service to obtain temperature information about a location
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
public interface TemperatureService {

    List<CityTemperatureDTO> findTempByCity(String city);

}
