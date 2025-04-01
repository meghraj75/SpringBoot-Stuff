package com.routeX.RoutexProjectAuthService.repository;

import com.routeX.RoutexProjectAuthService.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository <Passenger,Long> {
}
