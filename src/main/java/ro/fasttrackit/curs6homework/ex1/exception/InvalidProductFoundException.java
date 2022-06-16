package ro.fasttrackit.curs6homework.ex1.exception;

public class InvalidProductFoundException extends RuntimeException {
    public InvalidProductFoundException(String message) {
        super(message);
    }
}
