package com.example.MovieApp.service;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.Booking;
import com.example.MovieApp.model.Show;
import com.example.MovieApp.model.User;
import com.example.MovieApp.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }

    public Booking createBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepo.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = getBookingById(id);
        booking.setUser(bookingDetails.getUser());
        booking.setShow(bookingDetails.getShow());
        booking.setSeat(bookingDetails.getSeat());
        booking.setStatus(bookingDetails.getStatus());
        booking.setTotalPrice(bookingDetails.getTotalPrice());
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepo.delete(booking);
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingRepo.findByUser(user);
    }

    public List<Booking> getBookingsByShow(Show show) {
        return bookingRepo.findByShow(show);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepo.findByStatus(status);
    }

    public List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return bookingRepo.findByBookingTimeBetween(start, end);
    }
}