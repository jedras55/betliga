package pl.ostrowski.account.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Created by Jedras-PC on 25.01.2018. */
@Data
public class UserDto {
  @Email private String email;

  @Size(min = 4, max = 64)
  private String username;

  @NotNull private String password;

  @NotNull private String matchingPassword;
}
