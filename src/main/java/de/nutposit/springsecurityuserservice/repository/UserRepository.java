package de.nutposit.springsecurityuserservice.repository;

import de.nutposit.springsecurityuserservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);
    User findByEmail(String email);
}
