package com.example.tdd.services;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalcualtorWithDatabase(String name) {
        Optional<BookingModel> booking = bookingRepository.findByReserveName(name);
        return Period.between(booking.get().getCheckIn(), booking.get().getCheckOut()).getDays();
    }

}
