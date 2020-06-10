package com.restcountries.code.restcountriesApi.integrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ripul on 10 Jun 2020
 */
@Service
public class CapitalIntegrator {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${capital.countryname.url}")
    private String getCountryNameURL;

    @Value("${capital.countrycode.url}")
    private String getCountryCodeURL;

    public String getCapitalByCountryNameIntegrator(final String countryName) {
        final String url = getCountryNameURL.replace("{name}", countryName);
        final HttpHeaders headers =getHeaders();
        final HttpEntity request = new HttpEntity(headers);
        final ResponseEntity<String> capitalByCountryName = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return  capitalByCountryName.getBody();
    }

    public String getCapitalByCountryCodeIntegrator(final String countryCode) {
        final String url = getCountryCodeURL.replace("{code}", countryCode);
        final HttpHeaders headers =getHeaders();
        final HttpEntity request = new HttpEntity(headers);
        final ResponseEntity<String> capitalByCountryName = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return  capitalByCountryName.getBody();
    }

    HttpHeaders getHeaders(){
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
