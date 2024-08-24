package com.example.MovieApp.repo;

import com.example.MovieApp.model.Booking;
import com.example.MovieApp.model.Show;
import com.example.MovieApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByShow(Show show);
    List<Booking> findByStatus(String status);
    List<Booking> findByBookingTimeBetween(LocalDateTime start, LocalDateTime end);
}