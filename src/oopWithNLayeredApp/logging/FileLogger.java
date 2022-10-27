package oopWithNLayeredApp.logging;

public class FileLogger implements Logger{

    @Override
    public void log(String data) {
        System.out.println("File has been sent to database: : " + data);
    }
}
