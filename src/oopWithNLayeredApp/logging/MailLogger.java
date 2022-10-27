package oopWithNLayeredApp.logging;

public class MailLogger implements Logger{
    @Override
    public void log(String data) {
        System.out.println("E-mail has been sent to database: : " + data);
    }
}
