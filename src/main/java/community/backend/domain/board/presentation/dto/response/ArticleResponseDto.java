package community.backend.domain.board.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ArticleResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static ArticleResponseDto of(Long id, String title, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        return ArticleResponseDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
