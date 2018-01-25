package pl.ostrowski.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ostrowski.account.assembler.UserAssembler;
import pl.ostrowski.account.dto.UserDto;
import pl.ostrowski.account.model.User;
import pl.ostrowski.account.repository.UserRepository;
import pl.ostrowski.account.util.AccountConstants;

import java.util.regex.Pattern;

/** Created by Jedras-PC on 25.01.2018. */
@Service
public class RegisterService {

  private final UserRepository userRepository;
  private final UserAssembler userAssembler;

  @Autowired
  RegisterService(UserRepository userRepository, UserAssembler userAssembler) {
    this.userRepository = userRepository;
    this.userAssembler = userAssembler;
  }

  public void registerUser(UserDto userDto) {
    saveUser(userDto);
  }

  public boolean checkUsernameExists(String username) {
    return userRepository.existsByUsername(username);
  }

  public boolean checkEmailExists(String email) {
    return userRepository.existsByEmail(email);
  }

  private void saveUser(UserDto userDto) {
    if (!checkUsernameExists(userDto.getUsername())
        && !checkEmailExists(userDto.getEmail())
        && checkPasswordsMatches(userDto.getPassword(), userDto.getMatchingPassword())
        && checkPasswordMatchPattern(userDto.getPassword())) {
      User user = userAssembler.convertToDomain(userDto);
      user.setConfirmed(false);
      userRepository.save(user);
    }
  }

  private boolean checkPasswordsMatches(String password, String matchingPassword) {
    return password.equals(matchingPassword);
  }

  private boolean checkPasswordMatchPattern(String password) {
    return Pattern.compile(AccountConstants.PASSWORD_PATTERN).matcher(password).matches();
  }
}
