package community.backend.domain.board.presentation;

import community.backend.domain.board.presentation.dto.request.BoardRequestDto;
import community.backend.domain.board.presentation.dto.response.BoardResponseDto;
import community.backend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping
    public void createBoard(@RequestBody BoardRequestDto dto) {
        boardService.createBoard(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
