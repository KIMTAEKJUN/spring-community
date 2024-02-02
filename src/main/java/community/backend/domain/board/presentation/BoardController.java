package community.backend.domain.board.presentation;

import community.backend.domain.board.presentation.dto.request.ArticleRequestDto;
import community.backend.domain.board.presentation.dto.request.BoardRequestDto;
import community.backend.domain.board.presentation.dto.response.ArticleResponseDto;
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

    // Article
    @GetMapping("/{id}/articles")
    public List<ArticleResponseDto> getArticles(@PathVariable Long id, @RequestParam(defaultValue = "1") int page) {
        return boardService.getArticles(id, page);
    }

    @GetMapping("/{id}/article/{articleId}")
    public ArticleResponseDto getArticle(@PathVariable Long id, @PathVariable Long articleId) {
        return boardService.getArticle(id, articleId);
    }

    @PostMapping("/{id}/article")
    public void postArticle(@PathVariable Long id, @RequestBody ArticleRequestDto dto) {
        boardService.postArticle(id, dto);
    }

    @PutMapping("/{id}/article/{articleId}")
    public void updateArticle(@PathVariable Long id, @PathVariable Long articleId, @RequestBody ArticleRequestDto dto) {
        boardService.updateArticle(id, articleId, dto);
    }

    @DeleteMapping("/{id}/article/{articleId}")
    public void deleteArticle(@PathVariable Long id, @PathVariable Long articleId) {
        boardService.deleteArticle(id, articleId);
    }
}
