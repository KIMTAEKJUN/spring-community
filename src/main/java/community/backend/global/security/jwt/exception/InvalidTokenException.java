package community.backend.global.security.jwt.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class InvalidTokenException extends GlobalException {
    public static final GlobalException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.TOKEN_INVALID, ErrorCode.TOKEN_INVALID.getMessage());
    }
}
