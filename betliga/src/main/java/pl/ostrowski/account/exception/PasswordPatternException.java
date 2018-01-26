package pl.ostrowski.account.exception;

/**
 * Created by Jedras-PC on 26.01.2018.
 */
public class PasswordPatternException extends Exception {

    public PasswordPatternException() {
        super("Hasło nie pasuje do formy");
    }
}
