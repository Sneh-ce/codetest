package com.restcountries.code.restcountriesApi.service.impl;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.restcountries.code.restcountriesApi.domain.BaseCountry;
import com.restcountries.code.restcountriesApi.integrator.CapitalIntegrator;
import com.restcountries.code.restcountriesApi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ripul on 10 Jun 2020
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CapitalIntegrator capitalIntegrator;

    @Override
    public String getCapitalByCountryName(String countryName) {
        String response = capitalIntegrator.getCapitalByCountryNameIntegrator(countryName);

        List<BaseCountry> singLe = loadJson(response);
        String responseCap =  singLe.get(0).getCapital();
        return responseCap;
    }
    protected List<BaseCountry> loadJson(String response) {

        List<BaseCountry> countries = new ArrayList<>();
        InputStream is = new ByteArrayInputStream(response.getBytes(Charset.forName("UTF-8")));
        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            reader.beginArray();
            while(reader.hasNext()) {
                BaseCountry country = gson.fromJson(reader, BaseCountry.class);
                countries.add(country);
            }
        } catch (Exception e) {

        }
        return countries;
    }
    @Override
    public String getCapitalByCountryCode(String countryCode) {
        String response = capitalIntegrator.getCapitalByCountryCodeIntegrator(countryCode);
        List<BaseCountry> singLe = loadJson(response);
        String responseCap =  singLe.get(0).getCapital();
        return responseCap;
    }
}
