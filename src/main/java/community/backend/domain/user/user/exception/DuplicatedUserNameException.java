package community.backend.domain.user.user.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class DuplicatedUserNameException extends GlobalException {
    public static final GlobalException EXCEPTION = new DuplicatedUserNameException();

    private DuplicatedUserNameException() {
        super(ErrorCode.USER_DUPLICATED_NAME, ErrorCode.USER_DUPLICATED_NAME.getMessage());
    }
}
