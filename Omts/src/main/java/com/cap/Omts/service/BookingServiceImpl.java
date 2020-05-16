package com.cap.Omts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.Omts.dao.BookingDao;
import com.cap.Omts.dto.Booking;


@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDao bookingDao;

	
	
	@Override
	public Booking addBooking(Booking booking) {
		
		return bookingDao.save(booking);
	}



	@Override
	public boolean deletebookingbyId(int bookingId) {
		// TODO Auto-generated method stub
		boolean b = bookingDao.existsById(bookingId);
		if (b) {
			bookingDao.deleteById(bookingId);
		} 
		return b;
		
	}



	@Override
	public List<Booking> getDetails() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

}
