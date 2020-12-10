package com.location.api.controller;

import com.location.api.service.TemperatureService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test for the TemperatureController
 *
 * @author  Vianny Molero
 * @since   2020-06-08
 */
public class TemperatureControllerTest {

    private TemperatureService service;

    @Test
    public void controllerInitializedCorrectly() {
        assertNotNull(new TemperatureController(service));
    }

}
