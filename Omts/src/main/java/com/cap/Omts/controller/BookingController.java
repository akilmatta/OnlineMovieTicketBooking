package com.cap.Omts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.Omts.dto.Booking;
import com.cap.Omts.service.BookingService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	// Do Booking
	@PostMapping(value = "/booking/doBooking", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}

	// Delete Booking
	@DeleteMapping("/delete/bookingId/{bookingId}")
	public ResponseEntity<String> deletebookingById(@PathVariable("bookingId") int bookingId) {
		System.out.println(bookingId);
		if (bookingService.deletebookingbyId(bookingId))
			return new ResponseEntity<String>("Cancelled tickets successfully", new HttpHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Booking id does not exist", new HttpHeaders(), HttpStatus.OK);

	}
	//Get booking details

	@GetMapping("/getDetails")
	public ResponseEntity<List<Booking>> getDetails() {

		List<Booking> getBookedDetails = bookingService.getDetails();
		return new ResponseEntity<>(getBookedDetails, HttpStatus.OK);
	}

}
