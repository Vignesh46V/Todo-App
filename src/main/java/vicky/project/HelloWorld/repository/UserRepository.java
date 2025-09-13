package vicky.project.HelloWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vicky.project.HelloWorld.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
