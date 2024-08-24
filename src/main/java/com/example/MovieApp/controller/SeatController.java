package com.example.MovieApp.controller;

import com.example.MovieApp.model.Seat;
import com.example.MovieApp.model.Theatre;
import com.example.MovieApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatService.createSeat(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seatDetails) {
        return seatService.updateSeat(id, seatDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/theatre/{theatreId}")
    public List<Seat> getSeatsByTheatre(@PathVariable Long theatreId) {
        Theatre theatre = new Theatre();
        theatre.setTid(theatreId);
        return seatService.getSeatsByTheatre(theatre);
    }

    @GetMapping("/row/{row}")
    public List<Seat> getSeatsByRow(@PathVariable String row) {
        return seatService.getSeatsByRow(row);
    }
}