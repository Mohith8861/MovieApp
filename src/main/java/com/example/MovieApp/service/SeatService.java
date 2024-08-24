package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.Seat;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepo;

    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    public Seat getSeatById(Long id) {
        return seatRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seat not found"));
    }

    public Seat createSeat(Seat seat) {
        return seatRepo.save(seat);
    }

    public Seat updateSeat(Long id, Seat seatDetails) {
        Seat seat = getSeatById(id);
        seat.setTheatre(seatDetails.getTheatre());
        seat.setSeatRow(seatDetails.getSeatRow());
        seat.setSeatColumn(seatDetails.getSeatColumn());
        return seatRepo.save(seat);
    }

    public void deleteSeat(Long id) {
        Seat seat = getSeatById(id);
        seatRepo.delete(seat);
    }

    public List<Seat> getSeatsByTheatre(Theatre theatre) {
        return seatRepo.findByTheatre(theatre);
    }

    public List<Seat> getSeatsByRow(String row) {
        return seatRepo.findBySeatRow(row);
    }
}