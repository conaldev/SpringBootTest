package com.minh.repository;

import com.minh.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends PagingAndSortingRepository<City,Long> {
    City getById(Long id);
}
