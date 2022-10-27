package oopWithNLayeredApp.logging;

public class DatabaseLogger implements Logger{

    @Override
    public void log(String data) {
        System.out.println("Sent to database: " + data);
    }
}
