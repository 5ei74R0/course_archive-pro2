package lib.util.exception;

public class ExistenceException extends Exception {
    public ExistenceException() {
        super();
    }
    public ExistenceException(String errorMessage) {
        super(errorMessage);
    }
}
