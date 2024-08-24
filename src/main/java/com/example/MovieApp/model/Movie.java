package com.example.MovieApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    public String title;
    public String language;
    public String description;
    public Float rating;
    public Integer duration;
    public List<String> genre;
    public String certificate;
    public List<String> movieCast;
    public String director;
    public Integer year;
    public String imageUrl;
}
//Trailer, Start Date, End Date etc