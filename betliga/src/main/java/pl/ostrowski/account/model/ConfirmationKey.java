package pl.ostrowski.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.ostrowski.account.util.AccountConstants;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Jedras-PC on 28.01.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmationKey {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String confirmationKey;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public ConfirmationKey(User user) {
        this.confirmationKey = UUID.randomUUID().toString();
        this.user = user;
        this.expiryDate = generateExpiryDate();
    }

    private Date generateExpiryDate() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime nextTime = currentTime.plusHours(AccountConstants.TOKEN_EXPIRATION_TIME_IN_HOURS);
        Instant instant = nextTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
