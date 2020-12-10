package com.location.api.util;

import lombok.AllArgsConstructor;

/**
 * Calculate the convertion of Celcius to Fahrenheit
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
@AllArgsConstructor
public class CalculatorUtils {

    public static double convertToFahrenheit(double celcius){
        return (double) Math.round(((celcius * 1.8) + 32) * 1000d) / 1000d;
    }
}
