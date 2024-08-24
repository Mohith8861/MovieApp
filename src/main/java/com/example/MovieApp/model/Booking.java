package com.example.MovieApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bid;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    public User user;

    @ManyToOne
    @JoinColumn(name = "sid", nullable = false)
    public Show show;

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    public Seat seat;

    public LocalDateTime bookingTime;

    public String status;

    public Double totalPrice;

}
