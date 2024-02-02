package mihael.macuka.aidemo.service;

import mihael.macuka.aidemo.dto.CleaningPersonCommand;
import mihael.macuka.aidemo.model.CleaningPerson;

public interface CleaningPersonService {
    CleaningPerson addCleaningPerson(CleaningPersonCommand cleaningPersonCommand);
}