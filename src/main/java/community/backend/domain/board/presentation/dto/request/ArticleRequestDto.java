package community.backend.domain.board.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequestDto {
    @NotBlank(message = "작성자를 입력해주세요.")
    @Size(min = 2, max = 20, message = "작성자는 2~20자 이내로 작성해주세요.")
    private String author;

    @NotBlank(message = "게시글 제목을 입력해주세요.")
    @Size(min = 2, max = 30, message = "게시글 제목은 2~20자 이내로 작성해주세요.")
    private String title;

    @NotBlank(message = "게시글 내용을 입력해주세요.")
    @Size(min = 1, max = 500, message = "게시글 내용은 1~500자 이내로 작성해주세요.")
    private String content;
}
