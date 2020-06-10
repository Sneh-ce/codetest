package com.restcountries.code.restcountriesApi;

import com.restcountries.code.restcountriesApi.controller.CountryController;
import com.restcountries.code.restcountriesApi.service.CountryService;
import com.restcountries.code.restcountriesApi.service.impl.CountryServiceImpl;
import org.hamcrest.core.Is;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Ripul on 10 Jun 2020
 */

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {



    @InjectMocks
    CountryController countryController = new CountryController();;

    @Mock
    private CountryService countryService= new CountryServiceImpl();;
    /*@Before
    public void setUp() throws Exception {
        countryController = new CountryController();
        countryService = new CountryServiceImpl();
    }*/
    @Test
    public void getCapitalByCountryName() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        String response = countryController.getCapitalByCountryName(countryName);

        assertThat(response, is(expectedResponse));
    }

    @Test
    public void GetCapitalByCountryCode() {
        String countryCode = "co";
        String expectedResponse = "co";

        when(countryService.getCapitalByCountryCode(countryCode)).thenReturn(expectedResponse);

        String response = countryController.GetCapitalByCountryCode(countryCode);

        assertThat(response, is(expectedResponse));
    }

    @Test
    public void testAssertEquals() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        String response = countryController.getCapitalByCountryName(countryName);

        assertEquals(response, is(expectedResponse));
    }

    @Test
    public void testAssertFalse() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn1";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        boolean response = countryController.getCapitalByCountryName(countryName).equals(expectedResponse);


        assertFalse(response);
       // assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNotNull() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        String response = countryController.getCapitalByCountryName(countryName);

        assertNotNull(response, is(expectedResponse));
        //assertNotNull("should not be null", new Object());
    }
    @Test
    public void testAssertNull() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        String response = countryController.getCapitalByCountryName(countryName);

        assertNull(response, is(expectedResponse));
        //assertNull("should be null", null);
    }
    @Test
    public void testAssertSame() {
        String countryName = "eesti";
        String expectedResponse = "Tallinn";

        when(countryService.getCapitalByCountryName(countryName)).thenReturn(expectedResponse);

        String response = countryController.getCapitalByCountryName(countryName);
        String response1 = countryController.getCapitalByCountryName(countryName);
        assertSame("should be same", response, response1);
    }
}
