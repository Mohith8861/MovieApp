package com.example.MovieApp.controller;

import com.example.MovieApp.model.City;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.createTheatre(theatre);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Long id, @RequestBody Theatre theatreDetails) {
        return theatreService.updateTheatre(id, theatreDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/{cityId}")
    public List<Theatre> getTheatresByCity(@PathVariable Long cityId) {
        City city = new City();
        city.setCid(cityId);
        return theatreService.getTheatresByCity(city);
    }

    @GetMapping("/rating/{rating}")
    public List<Theatre> getTheatresByRating(@PathVariable Float rating) {
        return theatreService.getTheatresByRating(rating);
    }
}