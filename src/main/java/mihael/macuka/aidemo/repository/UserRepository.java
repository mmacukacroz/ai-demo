package mihael.macuka.aidemo.repository;

import mihael.macuka.aidemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}