package pl.ostrowski.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.ostrowski.account.assembler.UserAssembler;
import pl.ostrowski.account.dto.UserDto;
import pl.ostrowski.account.exception.EmailExistsException;
import pl.ostrowski.account.exception.PasswordMatcherException;
import pl.ostrowski.account.exception.PasswordPatternException;
import pl.ostrowski.account.exception.UsernameExistsException;
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

  public ResponseEntity registerUser(UserDto userDto) {
    try {
      saveUser(userDto);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    // TODO Potwierdzenie maila
    return new ResponseEntity(HttpStatus.OK);
  }

  public boolean checkUsernameExists(String username) {
    return userRepository.existsByUsername(username);
  }

  public boolean checkEmailExists(String email) {
    return userRepository.existsByEmail(email);
  }

  private void saveUser(UserDto userDto)
          throws PasswordPatternException, PasswordMatcherException, EmailExistsException,
          UsernameExistsException {
    if (!checkUsernameExists(userDto.getUsername())) {
      if (!checkEmailExists(userDto.getEmail())) {
        if (checkPasswordsMatches(userDto.getPassword(), userDto.getMatchingPassword())) {
          if (checkPasswordMatchPattern(userDto.getPassword())) {
            User user = userAssembler.convertToDomain(userDto);
            user.setConfirmed(false);
            userRepository.save(user);
          } else {
            throw new PasswordPatternException();
          }
        } else {
          throw new PasswordMatcherException();
        }
      } else {
        throw new EmailExistsException();
      }
    } else {
      throw new UsernameExistsException();
    }
  }

  private boolean checkPasswordsMatches(String password, String matchingPassword) {
    return password.equals(matchingPassword);
  }

  private boolean checkPasswordMatchPattern(String password) {
    return Pattern.compile(AccountConstants.PASSWORD_PATTERN).matcher(password).matches();
  }
}
