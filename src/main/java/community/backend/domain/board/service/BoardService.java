package community.backend.domain.board.service;

import community.backend.domain.board.domain.Article;
import community.backend.domain.board.domain.Board;
import community.backend.domain.board.domain.repository.ArticleRepository;
import community.backend.domain.board.domain.repository.BoardRepository;
import community.backend.domain.board.exception.article.ArticleNotFoundException;
import community.backend.domain.board.exception.board.BoardNotFoundException;
import community.backend.domain.board.exception.board.DuplicatedBoardException;
import community.backend.domain.board.presentation.dto.request.ArticleRequestDto;
import community.backend.domain.board.presentation.dto.request.BoardRequestDto;
import community.backend.domain.board.presentation.dto.response.ArticleResponseDto;
import community.backend.domain.board.presentation.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    // Board
    // TODO: 예외처리 = 하나뿐민 게시글을 삭제한 후 다시 조회하면, 빈 배열의 게시판이 아니라 게시판이 없다고 나옴
    public List<BoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAllByOrderByCreatedAtDesc();

        if (boards.isEmpty()) {
            throw BoardNotFoundException.EXCEPTION;
        }

        return BoardResponseDto.of(boards);
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        return BoardResponseDto.of(board);
    }

    public void createBoard(BoardRequestDto dto) {
        Board board = Board.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        if (boardRepository.findByName(board.getName()).isPresent()) {
            throw DuplicatedBoardException.EXCEPTION;
        }

        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        boardRepository.delete(board);
    }

    // Article
    // TODO: 새로운 게시판에 글을 작성하면, 해당 게시글의 id가 1로 시작하게 변경
    // 현재는 이런 식으로 됌 ex) board1 = 1,2,3,4 / board2 = 4,5,6,7
    public List<ArticleResponseDto> getArticles(Long id, int page) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        List<Article> articlesList = articleRepository.findAllByBoardOrderByCreatedAtDesc(board);

        if (articlesList.isEmpty()) {
            throw ArticleNotFoundException.EXCEPTION;
        }

        int pageSize = 10;
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, articlesList.size());

        List<Article> articles = articlesList.subList(start, end);

        return ArticleResponseDto.of(articles);
    }

    public ArticleResponseDto getArticle(Long id, Long articleId) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        Article article = articleRepository.findByIdAndBoard(articleId, board)
                .orElseThrow(() -> ArticleNotFoundException.EXCEPTION);

        return ArticleResponseDto.of(article);
    }

    public void postArticle(Long id, ArticleRequestDto dto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        Article article = Article.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .content(dto.getContent())
                .board(board)
                .build();

        articleRepository.save(article);
    }

    public void updateArticle(Long id, Long articleId, ArticleRequestDto dto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        Article article = articleRepository.findByIdAndBoard(articleId, board)
                .orElseThrow(() -> ArticleNotFoundException.EXCEPTION);

        article.updateArticle(dto.getTitle(), dto.getContent());
        articleRepository.save(article);
    }

    public void deleteArticle(Long id, Long articleId) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        Article article = articleRepository.findByIdAndBoard(articleId, board)
                .orElseThrow(() -> ArticleNotFoundException.EXCEPTION);

        articleRepository.delete(article);
    }
}
