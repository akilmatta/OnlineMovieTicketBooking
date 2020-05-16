package com.cap.Omts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.Omts.dto.Booking;



public interface BookingDao extends JpaRepository<Booking, Integer> {

}
