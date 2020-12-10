package com.location.api.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test to Calculate the convertion of Celcius to Fahrenheit
 *
 * @author  Vianny Molero
 * @since   2020-06-07
 */
public class CalculatorUtilsTest {

    @Test
    public void convertToFahrenheit() {
        assertEquals(59.189, CalculatorUtils.convertToFahrenheit(15.105));
        assertEquals(63.491, CalculatorUtils.convertToFahrenheit(17.494999999999997));
    }

}
