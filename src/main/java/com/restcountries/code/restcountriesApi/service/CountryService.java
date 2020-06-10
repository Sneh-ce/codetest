package com.restcountries.code.restcountriesApi.service;

import org.springframework.stereotype.Service;

/**
 * Created by Ripul on 10 Jun 2020
 */
public interface CountryService {
    String getCapitalByCountryName(String countryName);

    String getCapitalByCountryCode(String countryCode);
}
