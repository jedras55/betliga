package pl.ostrowski.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.ostrowski.account.dto.UserDto;
import pl.ostrowski.account.service.RegisterService;

import javax.validation.Valid;

/** Created by Jedras-PC on 25.01.2018. */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

  private final RegisterService registerService;

  @Autowired
  public RegisterController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseEntity registerUser(@Valid @RequestBody UserDto userDto) {
    return registerService.registerUser(userDto);
  }

    @RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
  @ResponseBody
  public boolean checkUsername(@RequestBody String username) {
    return registerService.checkUsernameExists(username);
  }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
  @ResponseBody
  public boolean checkEmail(@RequestBody String email) {
    return registerService.checkEmailExists(email);
  }

    @RequestMapping(value = "/{username}/{confirmationKey}/confirm", method = RequestMethod.GET)
    @ResponseBody
    public boolean confirmAccount(
            @PathVariable("username") String username,
            @PathVariable("confirmationKey") String confirmationKey) {
        return registerService.confirmAccount(username, confirmationKey);
    }
}
