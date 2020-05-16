package com.cap.Omts.service;

import java.util.List;

import com.cap.Omts.dto.Booking;

public interface BookingService {
	
	public Booking addBooking (Booking booking);
	boolean deletebookingbyId(int bookingId);
	public List<Booking> getDetails();

}
