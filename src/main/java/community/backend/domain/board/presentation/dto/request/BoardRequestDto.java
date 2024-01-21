package community.backend.domain.board.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {
    @NotBlank(message = "게시판 이름을 입력해주세요.")
    @Size(min = 2, max = 20, message = "게시판 이름은 2~20자 이내로 작성해주세요.")
    private String name;

    @NotBlank(message = "게시판 설명을 입력해주세요.")
    @Size(min = 2, max = 100, message = "게시판 설명은 2~100자 이내로 작성해주세요.")
    private String description;
}
