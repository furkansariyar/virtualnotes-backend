package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserId(int userId);
    User getUserByUsername(String username);
}
