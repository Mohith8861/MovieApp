package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.City;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.repo.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepo theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theatre not found"));
    }

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Long id, Theatre theatreDetails) {
        Theatre theatre = getTheatreById(id);
        theatre.setName(theatreDetails.getName());
        theatre.setAddress(theatreDetails.getAddress());
        theatre.setRating(theatreDetails.getRating());
        theatre.setSeatsNo(theatreDetails.getSeatsNo());
        theatre.setCity(theatreDetails.getCity());
        theatre.setType(theatreDetails.getType());
        theatre.setAveragePrice(theatreDetails.getAveragePrice());
        theatre.setRows(theatreDetails.getRows());
        theatre.setColumns(theatreDetails.getColumns());
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Long id) {
        Theatre theatre = getTheatreById(id);
        theatreRepository.delete(theatre);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatreRepository.findByCity(city);
    }

    public List<Theatre> getTheatresByRating(Float rating) {
        return theatreRepository.findByRatingGreaterThan(rating);
    }
}
