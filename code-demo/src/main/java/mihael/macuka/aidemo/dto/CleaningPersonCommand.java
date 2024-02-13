package mihael.macuka.aidemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CleaningPersonCommand {
    private String name;
    private String surname;
    private String addressStreetName;
    private String addressStreetNumber;
    private LocalDate dateOfBirth;
}