package calendar.exceptions;

public class NoFileException extends Exception {
    public void noFile() {
        System.out.println("The file doesn't exist.");
    }
}
