package com.routex.reviewservice.repository;


import com.routex.reviewservice.model.Booking;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
