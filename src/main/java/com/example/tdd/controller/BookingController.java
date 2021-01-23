package com.example.tdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.model.BookingModel;
import com.example.tdd.services.BookingService;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping
	public ResponseEntity<String> findAll() {
		
		return ResponseEntity.ok().body("Funcionou");
	}
}
