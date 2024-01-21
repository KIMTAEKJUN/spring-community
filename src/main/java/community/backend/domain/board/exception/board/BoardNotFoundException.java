package community.backend.domain.board.exception.board;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class BoardNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new BoardNotFoundException();

    private BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND, ErrorCode.BOARD_NOT_FOUND.getMessage());
    }
}
