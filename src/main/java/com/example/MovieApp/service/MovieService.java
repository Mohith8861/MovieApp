package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie createMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = getMovieById(id);
        movie.setTitle(movieDetails.getTitle());
        movie.setLanguage(movieDetails.getLanguage());
        movie.setDescription(movieDetails.getDescription());
        movie.setRating(movieDetails.getRating());
        movie.setDuration(movieDetails.getDuration());
        movie.setGenre(movieDetails.getGenre());
        movie.setCertificate(movieDetails.getCertificate());
        movie.setMovieCast(movieDetails.getMovieCast());
        movie.setDirector(movieDetails.getDirector());
        movie.setYear(movieDetails.getYear());
        movie.setImageUrl(movieDetails.getImageUrl());
        return movieRepo.save(movie);
    }

    public void deleteMovie(Long id) {
        Movie movie = getMovieById(id);
        movieRepo.delete(movie);
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepo.findByLanguage(language);
    }

    public List<Movie> getMoviesByRating(Float rating) {
        return movieRepo.findByRatingGreaterThan(rating);
    }

    public List<Movie> getMoviesByYear(Integer year) {
        return movieRepo.findByYear(year);
    }
}