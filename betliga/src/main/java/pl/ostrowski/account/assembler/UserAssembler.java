package pl.ostrowski.account.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.ostrowski.account.dto.UserDto;
import pl.ostrowski.account.model.User;
import pl.ostrowski.util.Assembler;

/** Created by Jedras-PC on 25.01.2018. */
@Component
public class UserAssembler extends Assembler<User, UserDto> {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserAssembler(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDto convertToBusiness(User user) {
    return null;
  }

  @Override
  public User convertToDomain(UserDto userDto) {
    return User.builder()
        .username(userDto.getUsername())
        .email(userDto.getEmail())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .build();
  }
}
