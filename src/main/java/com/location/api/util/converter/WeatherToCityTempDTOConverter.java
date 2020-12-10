package com.location.api.util.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.location.api.dto.CityTemperatureDTO;
import com.location.api.feign.model.ConsolidatedWeather;
import com.location.api.feign.model.Weather;
import com.location.api.util.CalculatorUtils;
import org.springframework.util.ObjectUtils;

/**
 * Converter Weather to CityTemperatureDTO
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
public class WeatherToCityTempDTOConverter implements
        Converter<Weather, CityTemperatureDTO> {

    @Override
    public CityTemperatureDTO convert(Weather source){
        ConsolidatedWeather consolidatedWeather = new ConsolidatedWeather();
        if(!source.getConsolidated_weather().isEmpty()){
            consolidatedWeather = source.getConsolidated_weather().get(source.getConsolidated_weather().size() - 1);
        }
        double fahrenheit = CalculatorUtils.convertToFahrenheit(
                ObjectUtils.isEmpty(consolidatedWeather.getThe_temp()) ? 0 : consolidatedWeather.getThe_temp());

        return CityTemperatureDTO.builder()
                .title(source.getTitle())
                .location_type(source.getLocation_type())
                .woeid(source.getWoeid())
                .latt_long(source.getLatt_long())
                .timezone(source.getTimezone())
                .applicable_date(consolidatedWeather.getApplicable_date())
                .temp_celsius(consolidatedWeather.getThe_temp())
                .temp_fahrenheit(fahrenheit)
                .build();
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

}
