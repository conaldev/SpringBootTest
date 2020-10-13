package com.minh.service;

import com.minh.model.City;
import com.minh.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findALl() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.getById(id);
    }

    @Override
    public void removeCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }
}
