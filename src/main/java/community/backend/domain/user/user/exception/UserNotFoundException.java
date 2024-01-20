package community.backend.domain.user.user.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND, ErrorCode.USER_NOT_FOUND.getMessage());
    }
}
