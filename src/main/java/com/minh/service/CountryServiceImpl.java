package com.minh.service;

import com.minh.model.Country;
import com.minh.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Iterable<Country> findALl() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCityById(Long id) {
        return countryRepository.getById(id);
    }

    @Override
    public void removeCity(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public void saveCity(Country country) {
        countryRepository.save(country);
    }
}
