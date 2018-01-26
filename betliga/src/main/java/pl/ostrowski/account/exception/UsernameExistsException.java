package pl.ostrowski.account.exception;

/**
 * Created by Jedras-PC on 26.01.2018.
 */
public class UsernameExistsException extends Exception {

    public UsernameExistsException() {
        super("Użytkownik istnieje");
    }
}
