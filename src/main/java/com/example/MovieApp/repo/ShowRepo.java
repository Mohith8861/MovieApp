package com.example.MovieApp.repo;


import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Show;
import com.example.MovieApp.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShowRepo extends JpaRepository<Show, Long> {
    List<Show> findByMovie(Movie movie);
    List<Show> findByTheatre(Theatre theatre);
    List<Show> findByDate(LocalDate date);
    List<Show> findByTime(LocalTime time);
}