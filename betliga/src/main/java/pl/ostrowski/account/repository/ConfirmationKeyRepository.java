package pl.ostrowski.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ostrowski.account.model.ConfirmationKey;
import pl.ostrowski.account.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Jedras-PC on 25.01.2018.
 */
public interface ConfirmationKeyRepository extends JpaRepository<ConfirmationKey, String> {
    ConfirmationKey findByUser(User user);

    List<ConfirmationKey> findByExpiryDateLessThanEqual(Date actualDate);
}
