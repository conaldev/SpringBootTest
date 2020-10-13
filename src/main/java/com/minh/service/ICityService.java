package com.minh.service;

import com.minh.model.City;

public interface ICityService {
    Iterable<City> findALl();
    City getCityById(Long id);
    void removeCity(City city);
    void saveCity(City city);
}
