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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String streetName;

    private String streetNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<User> users;
}