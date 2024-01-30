package mihael.macuka.aidemo.controller;

import mihael.macuka.aidemo.model.Booking;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bookings")
public class DemoController {
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") String id) {
    return new Booking(id, LocalDate.parse("2020-05-10"), LocalDate.parse("2020-05-12"), "John Smith");
    }
}
