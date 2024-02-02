package community.backend.domain.board.presentation.dto.response;

import community.backend.domain.board.domain.Board;
import community.backend.domain.board.exception.board.BoardNotFoundException;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class BoardResponseDto {
    private Long id;
    private String name;
    private String description;

    public static BoardResponseDto of(Board board) {
        if (board == null) throw BoardNotFoundException.EXCEPTION;

        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .description(board.getDescription())
                .build();
    }

    public static List<BoardResponseDto> of(List<Board> boards) {
        if (boards == null) throw BoardNotFoundException.EXCEPTION;

        return boards.stream()
                .map(BoardResponseDto::of)
                .collect(Collectors.toList());
    }
}
