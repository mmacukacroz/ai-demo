package mihael.macuka.aidemo.service.impl;

import mihael.macuka.aidemo.model.Address;
import mihael.macuka.aidemo.repository.AddressRepository;
import mihael.macuka.aidemo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, EntityManager entityManager) {
        this.addressRepository = addressRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressByUserId(Long userId) {
        TypedQuery<Address> query = entityManager.createNamedQuery("Address.findByUserId", Address.class);
        query.setParameter("userId", userId);
        final List<Address> addresses = query.getResultList();
        return addresses.size() > 0 ? addresses.get(0) : null;
    }
}