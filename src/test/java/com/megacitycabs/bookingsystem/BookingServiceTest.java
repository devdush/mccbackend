package com.megacitycabs.bookingsystem;

import com.megacitycabs.bookingsystem.model.Booking;
import com.megacitycabs.bookingsystem.repository.BookingRepository;
import com.megacitycabs.bookingsystem.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void testCreateBooking() {
        Booking booking = new Booking();
        booking.setPickupLocation("Colombo");
        booking.setDropoffLocation("Kandy");

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking savedBooking = bookingService.createBooking(booking);

        assertNotNull(savedBooking);
        assertEquals("Colombo", savedBooking.getPickupLocation());
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }
}
