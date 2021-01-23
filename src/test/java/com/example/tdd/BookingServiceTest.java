package com.example.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repositories.BookingRepository;
import com.example.tdd.services.BookingService;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {
	
	@TestConfiguration
	static class BookingServiceTestConfiguration {
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}
	
	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository bookingRepository;
	
	@Test
	public void bookingTestCalculationDays() {
		String name = "Jon Doe";
		int days = bookingService.daysCalcualtorWithDatabase(name);
		
		Assertions.assertEquals(days, 10);
	}
	
	@BeforeEach
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2021-01-10");
		LocalDate checkOut = LocalDate.parse("2021-01-20");
		
		BookingModel model = new BookingModel("1", "Jon Doe", checkIn, checkOut, 2);
		
		Mockito.when(bookingRepository.findByReserveName(model.getReserveName())).thenReturn(Optional.of(model));
	}
}

