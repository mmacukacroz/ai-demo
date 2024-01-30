package mihael.macuka.aidemo.service;

import mihael.macuka.aidemo.model.Booking;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(String id);
}