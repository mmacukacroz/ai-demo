package mihael.macuka.aidemo.service.impl;

import mihael.macuka.aidemo.dto.CleaningPersonCommand;
import mihael.macuka.aidemo.model.Address;
import mihael.macuka.aidemo.model.CleaningPerson;
import mihael.macuka.aidemo.repository.AddressRepository;
import mihael.macuka.aidemo.repository.CleaningPersonRepository;
import mihael.macuka.aidemo.service.CleaningPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningPersonServiceImpl implements CleaningPersonService {

    private final CleaningPersonRepository cleaningPersonRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public CleaningPersonServiceImpl(CleaningPersonRepository cleaningPersonRepository, AddressRepository addressRepository) {
        this.cleaningPersonRepository = cleaningPersonRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public CleaningPerson addCleaningPerson(CleaningPersonCommand cleaningPersonCommand) {
        CleaningPerson cleaningPerson = new CleaningPerson();
        cleaningPerson.setName(cleaningPersonCommand.getName());
        cleaningPerson.setSurname(cleaningPersonCommand.getSurname());

        // Convert the address string to an Address object
        Address address = addressRepository.findByStreetNameAndStreetNumber(
            cleaningPersonCommand.getAddressStreetName(), 
            cleaningPersonCommand.getAddressStreetNumber()
        );
        if (address == null) {
            address = new Address();
            address.setStreetName(cleaningPersonCommand.getAddressStreetName());
            address.setStreetNumber(cleaningPersonCommand.getAddressStreetNumber());
            address = addressRepository.save(address);
        }
        cleaningPerson.setAddress(address);

        cleaningPerson.setDateOfBirth(cleaningPersonCommand.getDateOfBirth());
        return cleaningPersonRepository.save(cleaningPerson);
    }
}