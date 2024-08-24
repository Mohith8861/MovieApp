package com.example.MovieApp.repo;

import com.example.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

    public Movie findMovieByTitle(String s);
    public List<Movie> findAllMoviesByDirector(String s);
    public List<Movie> findByTitle(String title);
    public List<Movie> findByLanguage(String language);
    public List<Movie> findByRatingGreaterThan(Float rating);
    public List<Movie> findByYear(Integer year);
}
