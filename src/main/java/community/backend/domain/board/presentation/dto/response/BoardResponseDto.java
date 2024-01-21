package community.backend.domain.board.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponseDto {
    private Long id;
    private String name;
    private String description;

    public static BoardResponseDto of(Long id, String name, String description) {
        return BoardResponseDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }
}
