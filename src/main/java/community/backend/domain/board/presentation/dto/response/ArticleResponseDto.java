package community.backend.domain.board.presentation.dto.response;

import community.backend.domain.board.domain.Article;
import community.backend.domain.board.exception.article.ArticleNotFoundException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ArticleResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static ArticleResponseDto of(Article article) {
        if (article == null) throw ArticleNotFoundException.EXCEPTION;

        return ArticleResponseDto.builder()
                .id(article.getId())
                .author(article.getAuthor())
                .title(article.getTitle())
                .content(article.getContent())
                .createdDate(article.getCreatedDate())
                .modifiedDate(article.getModifiedDate())
                .build();
    }

    public static List<ArticleResponseDto> of(List<Article> articles) {
        if (articles == null) throw ArticleNotFoundException.EXCEPTION;

        return articles.stream()
                .map(ArticleResponseDto::of)
                .collect(java.util.stream.Collectors.toList());
    }
}
