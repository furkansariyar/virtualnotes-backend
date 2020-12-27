package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User getUserByUserId(UUID userId);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
}
