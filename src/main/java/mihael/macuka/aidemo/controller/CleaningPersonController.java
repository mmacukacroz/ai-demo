package mihael.macuka.aidemo.controller;

import mihael.macuka.aidemo.dto.CleaningPersonCommand;
import mihael.macuka.aidemo.model.CleaningPerson;
import mihael.macuka.aidemo.service.CleaningPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cleaningPerson")
public class CleaningPersonController {

    private final CleaningPersonService cleaningPersonService;

    @Autowired
    public CleaningPersonController(CleaningPersonService cleaningPersonService) {
        this.cleaningPersonService = cleaningPersonService;
    }

    @PostMapping
    public ResponseEntity<CleaningPerson> addCleaningPerson(@RequestBody CleaningPersonCommand cleaningPersonCommand) {
        CleaningPerson cleaningPerson = cleaningPersonService.addCleaningPerson(cleaningPersonCommand);
        return new ResponseEntity<>(cleaningPerson, HttpStatus.CREATED);
    }
}