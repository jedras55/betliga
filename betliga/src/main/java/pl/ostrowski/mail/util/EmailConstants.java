package pl.ostrowski.mail.util;

/**
 * Created by Jedras-PC on 29.01.2018.
 */
public class EmailConstants {

    public static final String AUTHOR_EMAIL = "authoremail@email.com";
    public static final String EMAIL_TITLE_PATTERN = "Potwierdzenie rejestracji w BetLidze";
    public static final String EMAIL_CONTENT_PATTERN = "Witaj %s! <br>Na twój adres email założone zostało konto w aplikacji BetLiga. <br>Jeśli Ty założyłeś to konto, możesz je potwierdzić klikając <a href=\"%s/register/%s/%s/confirm\">tutaj</a>. <br>Jeśli to nie Ty, zignoruj tę wiadomość. <br>Pozdrawiamy!";

    private EmailConstants() {
        throw new AssertionError("Inaccessible utility class constructor");
    }
}
