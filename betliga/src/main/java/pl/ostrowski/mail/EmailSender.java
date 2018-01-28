package pl.ostrowski.mail;

/**
 * Created by Jedras-PC on 29.01.2018.
 */
public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
