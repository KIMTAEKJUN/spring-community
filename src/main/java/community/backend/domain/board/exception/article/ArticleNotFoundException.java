package community.backend.domain.board.exception.article;

import community.backend.global.error.exception.ErrorCode;
import community.backend.global.error.exception.GlobalException;

public class ArticleNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new ArticleNotFoundException();

    private ArticleNotFoundException() {
        super(ErrorCode.ARTICLE_NOT_FOUND, ErrorCode.ARTICLE_NOT_FOUND.getMessage());
    }
}
