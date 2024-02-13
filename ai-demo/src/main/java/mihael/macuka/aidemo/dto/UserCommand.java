package mihael.macuka.aidemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String streetName;
    private String streetNumber;
}