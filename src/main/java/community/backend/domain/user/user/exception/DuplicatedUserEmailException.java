package community.backend.domain.user.user.exception;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class DuplicatedUserEmailException extends GlobalException {
    public static final GlobalException EXCEPTION = new DuplicatedUserEmailException();

    private DuplicatedUserEmailException() {
        super(ErrorCode.USER_DUPLICATED_EMAIL, ErrorCode.USER_DUPLICATED_EMAIL.getMessage());
    }
}
