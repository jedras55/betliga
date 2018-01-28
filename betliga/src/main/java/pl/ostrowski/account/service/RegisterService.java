package pl.ostrowski.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.ostrowski.account.assembler.UserAssembler;
import pl.ostrowski.account.dto.UserDto;
import pl.ostrowski.account.exception.EmailExistsException;
import pl.ostrowski.account.exception.PasswordMatcherException;
import pl.ostrowski.account.exception.PasswordPatternException;
import pl.ostrowski.account.exception.UsernameExistsException;
import pl.ostrowski.account.model.ConfirmationKey;
import pl.ostrowski.account.model.User;
import pl.ostrowski.account.repository.ConfirmationKeyRepository;
import pl.ostrowski.account.repository.UserRepository;
import pl.ostrowski.account.util.AccountConstants;
import pl.ostrowski.mail.EmailSenderImpl;

import java.util.Date;
import java.util.regex.Pattern;

/** Created by Jedras-PC on 25.01.2018. */
@Service
public class RegisterService {

  private final UserRepository userRepository;
  private final ConfirmationKeyRepository confirmationKeyRepository;
  private final UserAssembler userAssembler;
  private final EmailSenderImpl emailSender;

  @Autowired
  RegisterService(
          UserRepository userRepository,
          ConfirmationKeyRepository confirmationKeyRepository,
          UserAssembler userAssembler,
          EmailSenderImpl emailSender) {
    this.userRepository = userRepository;
    this.confirmationKeyRepository = confirmationKeyRepository;
    this.userAssembler = userAssembler;
    this.emailSender = emailSender;
  }

  public ResponseEntity registerUser(UserDto userDto) {
    try {
      saveUser(userDto);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    return new ResponseEntity(HttpStatus.OK);
  }

  public boolean checkUsernameExists(String username) {
    return userRepository.existsByUsername(username);
  }

  public boolean checkEmailExists(String email) {
    return userRepository.existsByEmail(email);
  }

  public boolean confirmAccount(String username, String confirmationKey) {
    boolean confirmResult = false;
    User user = userRepository.findByUsername(username);
    ConfirmationKey userConfirmationKey = confirmationKeyRepository.findByUser(user);
    if (userConfirmationKey != null
            && userConfirmationKey.getConfirmationKey().equals(confirmationKey)) {
      user.setConfirmed(true);
      userRepository.save(user);
      confirmationKeyRepository.delete(userConfirmationKey);
      confirmResult = true;
    }
    return confirmResult;
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
            ConfirmationKey confirmationKey = new ConfirmationKey(user);
            confirmationKeyRepository.save(confirmationKey);
            emailSender.sendEmail(
                    userDto.getEmail(),
                    "Potwierdzenie maila",
                    "<a href=\"http://localhost:8080/register/"
                            + user.getUsername()
                            + "/"
                            + confirmationKey.getConfirmationKey()
                            + "/confirm\"> tutaj</a>");
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

  @Scheduled(fixedDelay = 1000 * 60 * 5)
  private void deleteExpiredVerificationToken() {
    confirmationKeyRepository.delete(
            confirmationKeyRepository.findByExpiryDateLessThanEqual(new Date()));
  }
}
