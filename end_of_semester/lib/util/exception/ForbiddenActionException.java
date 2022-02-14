package lib.util.exception;

public class ForbiddenActionException extends Exception {
    public ForbiddenActionException() {
        super();
    }
    public ForbiddenActionException(String errorMessage) {
        super(errorMessage);
    }
}
