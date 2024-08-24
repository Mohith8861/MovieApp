package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Show;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.repo.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepo showRepo;

    public List<Show> getAllShows() {
        return showRepo.findAll();
    }

    public Show getShowById(Long id) {
        return showRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Show not found"));
    }

    public Show createShow(Show show) {
        return showRepo.save(show);
    }

    public Show updateShow(Long id, Show showDetails) {
        Show show = getShowById(id);
        show.setMovie(showDetails.getMovie());
        show.setTheatre(showDetails.getTheatre());
        show.setDate(showDetails.getDate());
        show.setTime(showDetails.getTime());
        show.setAveragePrice(showDetails.getAveragePrice());
        return showRepo.save(show);
    }

    public void deleteShow(Long id) {
        Show show = getShowById(id);
        showRepo.delete(show);
    }

    public List<Show> getShowsByMovie(Movie movie) {
        return showRepo.findByMovie(movie);
    }

    public List<Show> getShowsByTheatre(Theatre theatre) {
        return showRepo.findByTheatre(theatre);
    }

    public List<Show> getShowsByDate(LocalDate date) {
        return showRepo.findByDate(date);
    }
}