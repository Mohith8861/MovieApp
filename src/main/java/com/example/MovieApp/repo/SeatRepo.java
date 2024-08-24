package com.example.MovieApp.repo;

import com.example.MovieApp.model.Seat;
import com.example.MovieApp.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Long> {
    List<Seat> findByTheatre(Theatre theatre);
    List<Seat> findBySeatRow(String row);
}
