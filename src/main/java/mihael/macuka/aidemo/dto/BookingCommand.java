package mihael.macuka.aidemo.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingCommand {
    private LocalDate startDate;
    private LocalDate endDate;
    private String userId;
    private int roomNumber;
    private List<String> cleaningPersonIds;
}