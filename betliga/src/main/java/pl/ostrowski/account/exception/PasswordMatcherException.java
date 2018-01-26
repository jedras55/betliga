package pl.ostrowski.account.exception;

/**
 * Created by Jedras-PC on 26.01.2018.
 */
public class PasswordMatcherException extends Exception {

    public PasswordMatcherException() {
        super("Hasła nie pasują do siebie");
    }
}
