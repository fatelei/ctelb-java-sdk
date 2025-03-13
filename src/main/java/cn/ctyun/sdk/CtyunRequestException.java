package cn.ctyun.sdk;

public class CtyunRequestException extends Exception {

    public CtyunRequestException() {}

    public CtyunRequestException(String message) {
        super(message);
    }

    public CtyunRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CtyunRequestException(Throwable cause) {
        super(cause);
    }

    public CtyunRequestException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
