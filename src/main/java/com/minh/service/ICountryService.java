package com.minh.service;

import com.minh.model.Country;

public interface ICountryService {
    Iterable<Country> findALl();
    Country getCityById(Long id);
    void removeCity(Country country);
    void saveCity(Country country);
}
