package com.example.deparments.dto;

import java.io.Serializable;

public class CityDto implements Serializable {

    private String cityName;
    private String countryName;

    public CityDto(String cityName, String countryName) {
        super();
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
