package com.minh.controller;

import com.minh.model.City;
import com.minh.model.Country;
import com.minh.service.ICityService;
import com.minh.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    ICountryService countryService;
    @Autowired
    ICityService cityService;


    private Iterable<Country> getListCountries(){
        return countryService.findALl();
    }

    private Iterable<City> getListCity(){
        return cityService.findALl();
    }

    @GetMapping({"/","/home"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities",getListCity());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        City currentCity = cityService.getCityById(id);
        modelAndView.addObject("city",currentCity);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCity(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        City currentCity = cityService.getCityById(id);
        modelAndView.addObject("city",currentCity);
        modelAndView.addObject("countries",getListCountries());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        cityService.saveCity(city);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("messageStatus","Successfully Updated!");
        modelAndView.addObject("cities",getListCity());
        return modelAndView;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCity1(@RequestBody City city) {
        City city1 = cityService.getCityById(city.getId());
        cityService.removeCity(city1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/add")
    public ModelAndView addNewCity(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("countries",getListCountries());
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("city") City city){
        ModelAndView modelAndView  = new ModelAndView("index");
        cityService.saveCity(city);
        modelAndView.addObject("messageStatus","Successfully Created!");
        modelAndView.addObject("cities",getListCity());
        return modelAndView;
    }

}
