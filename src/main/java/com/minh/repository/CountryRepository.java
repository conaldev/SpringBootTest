package com.minh.repository;

import com.minh.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
    Country getById(Long id);
}
