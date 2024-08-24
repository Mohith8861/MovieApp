package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.City;
import com.example.MovieApp.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepo cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityDetails) {
        City city = getCityById(id);
        city.setName(cityDetails.getName());
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        City city = getCityById(id);
        cityRepository.delete(city);
    }

    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }
}