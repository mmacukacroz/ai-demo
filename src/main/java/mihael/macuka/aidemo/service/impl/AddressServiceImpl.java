package mihael.macuka.aidemo.service.impl;

import mihael.macuka.aidemo.model.Address;
import mihael.macuka.aidemo.repository.AddressRepository;
import mihael.macuka.aidemo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }
}