package mihael.macuka.aidemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String username;

    private String password;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}