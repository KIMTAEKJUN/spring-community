package community.backend.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "COMMON-001", "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "서버에 오류가 발생했습니다."),

    // User
    USER_INVALID_PASSWORD(403, "USER-001", "비밀번호가 일치하지 않습니다."),
    USER_NOT_FOUND(404, "USER-002", "사용자를 찾을 수 없습니다."),
    USER_DUPLICATED_EMAIL(409, "USER-003", "이미 가입된 이메일입니다."),
    USER_DUPLICATED_NAME(409, "USER-004", "이미 사용중인 이름입니다."),

    // Auth
    TOKEN_INVALID(401, "TOKEN-001", "유효하지 않은 토큰입니다."),
    TOKEN_EXPIRED(401, "TOKEN-002", "만료된 토큰입니다."),
    UNAUTHENTICATED(401, "USER-003","접근 권한이 없습니다"),

    // Board
    BOARD_NOT_FOUND(404, "BOARD-001", "게시판을 찾을 수 없습니다."),

    // Article
    ARTICLE_NOT_FOUND(404, "ARTICLE-001", "게시글을 찾을 수 없습니다."),
    ;
    private int status;
    private String code;
    private String message;
}
