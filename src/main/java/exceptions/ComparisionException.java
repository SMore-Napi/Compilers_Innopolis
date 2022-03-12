package exceptions;

public class ComparisionException extends RuntimeException{
    private boolean suppressStackTrace = false;

    // suppressStackTrace is true => we don't print the stack trace of exception
    // supressStackTrace is false => we pring the stack trace of excpetion
    public ComparisionException(String message, boolean suppressStackTrace) {
        super(message, null, suppressStackTrace, !suppressStackTrace);
        this.suppressStackTrace = suppressStackTrace;
    }

    @Override
    public String toString() {
        if (suppressStackTrace) {
            return getLocalizedMessage();
        } else {
            return super.toString();
        }
    }
}
