package mihael.macuka.aidemo.service.impl;

import mihael.macuka.aidemo.model.Booking;
import mihael.macuka.aidemo.model.User;
import mihael.macuka.aidemo.repository.BookingRepository;
import mihael.macuka.aidemo.repository.UserRepository;
import mihael.macuka.aidemo.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mihael.macuka.aidemo.dto.BookingCommand;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Booking ID cannot be null");
        }
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking saveBooking(final BookingCommand bookingCommand) {
        String userId = bookingCommand.getUserId();
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Booking booking = new Booking(null, bookingCommand.getStartDate(), bookingCommand.getEndDate(), user, bookingCommand.getRoomNumber());
        return bookingRepository.save(booking);
    }
}