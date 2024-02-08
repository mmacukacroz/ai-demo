package mihael.macuka.aidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Address.findByUserId",
            query = "SELECT a FROM Address a WHERE a.id = (SELECT u.address.id FROM User u WHERE u.id = :userId)")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Changed from String to Long

    private String streetName;

    private String streetNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<User> users;
}