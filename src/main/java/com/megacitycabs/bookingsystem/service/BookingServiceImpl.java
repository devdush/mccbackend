package com.megacitycabs.bookingsystem.service;
import com.megacitycabs.bookingsystem.model.Booking;
import com.megacitycabs.bookingsystem.model.BookingStatus;
import com.megacitycabs.bookingsystem.repository.BookingRepository;
import com.megacitycabs.bookingsystem.service.BookingService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingsByDriver(Long driverId) {
        return bookingRepository.findByDriverId(driverId);
    }

    @Override
    public Booking updateBookingStatus(Long id, BookingStatus status) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus(status);
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
