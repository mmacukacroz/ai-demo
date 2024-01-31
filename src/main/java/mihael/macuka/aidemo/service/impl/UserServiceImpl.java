package mihael.macuka.aidemo.service.impl;

import mihael.macuka.aidemo.dto.UserCommand;
import mihael.macuka.aidemo.model.User;
import mihael.macuka.aidemo.model.Address;
import mihael.macuka.aidemo.repository.UserRepository;
import mihael.macuka.aidemo.repository.AddressRepository;
import mihael.macuka.aidemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User saveUser(UserCommand userCommand) {
        Address address = addressRepository.findByStreetNameAndStreetNumber(userCommand.getStreetName(), userCommand.getStreetNumber());
        if (address == null) {
            address = new Address(null, userCommand.getStreetName(), userCommand.getStreetNumber(), null);
        }
        User user = new User(null, userCommand.getUsername(), userCommand.getPassword(), userCommand.getDateOfBirth(), address);
        return userRepository.save(user);
    }
}