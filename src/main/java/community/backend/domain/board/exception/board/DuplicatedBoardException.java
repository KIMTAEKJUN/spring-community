package community.backend.domain.board.exception.board;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class DuplicatedBoardException extends GlobalException {
    public static final GlobalException EXCEPTION = new DuplicatedBoardException();

    private DuplicatedBoardException() {
        super(ErrorCode.BOARD_DUPLICATED, ErrorCode.BOARD_DUPLICATED.getMessage());
    }
}
