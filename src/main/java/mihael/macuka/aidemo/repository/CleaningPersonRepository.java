package mihael.macuka.aidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mihael.macuka.aidemo.model.CleaningPerson;

public interface CleaningPersonRepository extends JpaRepository<CleaningPerson, String>{}
