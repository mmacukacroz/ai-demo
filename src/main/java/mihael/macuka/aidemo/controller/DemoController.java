package mihael.macuka.aidemo.controller;

import mihael.macuka.aidemo.dto.BookingCommand;
import mihael.macuka.aidemo.model.Booking;
import mihael.macuka.aidemo.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/bookings")
public class DemoController {

    private final BookingService bookingService;

    @Autowired
    public DemoController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        
        return ResponseEntity.ok(bookings);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") String id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody BookingCommand bookingCommand) {
        Booking booking = bookingService.saveBooking(bookingCommand);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(booking.getId())
            .toUri();
        return ResponseEntity.created(location).body(booking);
    }
}