package mihael.macuka.aidemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CleaningPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private LocalDate dateOfBirth;

    @JsonIgnore
    @ManyToMany(mappedBy = "cleaningPeople")
    private List<Booking> bookings;
}