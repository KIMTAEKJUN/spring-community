package community.backend.global.security.jwt.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class UnauthorizedException extends GlobalException {
    public static final GlobalException EXCEPTION = new UnauthorizedException();

    private UnauthorizedException() {
        super(ErrorCode.UNAUTHENTICATED, ErrorCode.UNAUTHENTICATED.getMessage());
    }
}
