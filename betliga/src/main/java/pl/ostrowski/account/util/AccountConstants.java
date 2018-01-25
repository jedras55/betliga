package pl.ostrowski.account.util;

/** Created by Jedras-PC on 25.01.2018. */
public class AccountConstants {
  public static final String PASSWORD_PATTERN =
      "^"
          + "(?=.*\\d)"
          + "(?=.*[a-z])"
          + "(?=.*[A-Z])"
          + "(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])"
          + "."
          + "{6,15}"
          + "$";

  private AccountConstants() {
    throw new AssertionError("Inaccessible utility class constructor");
  }
}
