package com.example.MovieApp.repo;

import com.example.MovieApp.model.City;
import com.example.MovieApp.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Long> {
    List<Theatre> findByCity(City city);
    List<Theatre> findByRatingGreaterThan(Float rating);
    List<Theatre> findByType(String type);
    List<Theatre> findByAveragePriceLessThan(Integer price);
}
