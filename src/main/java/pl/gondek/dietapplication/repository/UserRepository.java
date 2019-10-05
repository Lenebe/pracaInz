package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySecurity_SecurityId(Long id);
//    User findBySecurity_SecurityId(long id);
//    User findBySecurityId(String id);
//    User findBySecurityId(long id);

//    User findBy(String username);
//
//    User findByUsernameAndPassword(String username, String password);
}