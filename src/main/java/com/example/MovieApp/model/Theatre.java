package com.example.MovieApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long tid;
    public String name;
    public String address;
    public Float rating;
    public Integer seatsNo;
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    public List<Seat> seats;
    @ManyToOne
    @JoinColumn(name = "cid")
    public City city;
    public String type;
    public Integer averagePrice;
    public Integer rows;
    public Integer columns;

}
//Name, City, TicketPrice, Seats, Image, etc.