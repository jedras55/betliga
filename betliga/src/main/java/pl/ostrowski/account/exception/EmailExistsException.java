package pl.ostrowski.account.exception;

/**
 * Created by Jedras-PC on 26.01.2018.
 */
public class EmailExistsException extends Exception {

    public EmailExistsException() {
        super("Email istnieje");
  }
}
