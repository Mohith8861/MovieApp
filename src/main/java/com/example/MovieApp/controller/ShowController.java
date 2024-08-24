package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Show;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @PostMapping
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @PutMapping("/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody Show showDetails) {
        return showService.updateShow(id, showDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/movie/{movieId}")
    public List<Show> getShowsByMovie(@PathVariable Long movieId) {
        Movie movie = new Movie();
        movie.setMid(movieId);
        return showService.getShowsByMovie(movie);
    }

    @GetMapping("/theatre/{theatreId}")
    public List<Show> getShowsByTheatre(@PathVariable Long theatreId) {
        Theatre theatre = new Theatre();
        theatre.setTid(theatreId);
        return showService.getShowsByTheatre(theatre);
    }

    @GetMapping("/date/{date}")
    public List<Show> getShowsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return showService.getShowsByDate(date);
    }
}