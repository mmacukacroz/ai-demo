package mihael.macuka.aidemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BookingCommand {
    private LocalDate startDate;
    private LocalDate endDate;
    private String userId;
    private int roomNumber;
}