package com.routeX.ReviewService.model;


import jakarta.persistence.Entity;


public enum BookingStatus {
    Scheduled,
    Canceld,
    Cab_Arrived,
    Assiging_Driver,
    InRide,
    Completed
}
