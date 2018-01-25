package pl.ostrowski.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ostrowski.account.model.User;

/** Created by Jedras-PC on 25.01.2018. */
public interface UserRepository extends JpaRepository<User, String> {
  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
