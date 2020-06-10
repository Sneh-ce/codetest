package com.restcountries.code.restcountriesApi.controller;

import com.restcountries.code.restcountriesApi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ripul on 10 Jun 2020
 */
@RequestMapping("/v1")
@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping(path = "/getCapitalByCountryName/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCapitalByCountryName(@PathVariable(value = "countryName") String countryName ) {
        String response = new String();
        try{
            if(countryName == "" || countryName.length() == 0){
                response = "Country Name is mandatory";
            }else{
                response = countryService.getCapitalByCountryName(countryName);
            }
        }
        catch (Exception ee){
            System.out.println(ee);
        }


        return response;
    }

    @GetMapping(path = "/getCapitalByCountryCode/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String GetCapitalByCountryCode(@PathVariable(value = "countryCode") String countryCode) {
        String response = countryService.getCapitalByCountryCode(countryCode);
        return response;
    }
}
