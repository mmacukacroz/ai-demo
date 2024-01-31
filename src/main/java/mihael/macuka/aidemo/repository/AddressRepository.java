package mihael.macuka.aidemo.repository;

import mihael.macuka.aidemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreetNameAndStreetNumber(String streetName, String streetNumber);
}