package pl.ostrowski.account.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** Created by Jedras-PC on 25.01.2018. */
@Builder
@Data
@Entity
public class User {
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  private String username;
  private String email;
  private String password;
  private boolean confirmed;
}
