package pl.ostrowski.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  @ResponseStatus(value = HttpStatus.OK)
  public void registerUser(@Valid @RequestBody UserDto userDto) {
    registerService.registerUser(userDto);
  }

  @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
  @ResponseBody
  public boolean checkUsername(@RequestBody String username) {
    return registerService.checkUsernameExists(username);
  }

  @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
  @ResponseBody
  public boolean checkEmail(@RequestBody String email) {
    return registerService.checkEmailExists(email);
  }
}
