package community.backend.domain.user.user.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class PasswordMismatchException extends GlobalException {
    public static final GlobalException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.USER_INVALID_PASSWORD, ErrorCode.USER_INVALID_PASSWORD.getMessage());
    }
}
