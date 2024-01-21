package community.backend.domain.board.service;

import community.backend.domain.board.domain.Board;
import community.backend.domain.board.domain.repository.BoardRepository;
import community.backend.domain.board.exception.board.BoardNotFoundException;
import community.backend.domain.board.exception.board.DuplicatedBoardException;
import community.backend.domain.board.presentation.dto.request.BoardRequestDto;
import community.backend.domain.board.presentation.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAllByOrderByCreatedAtDesc();

        if (boards.isEmpty()) {
            throw BoardNotFoundException.EXCEPTION;
        }

        return boards.stream()
                .map(board -> BoardResponseDto.of(board.getId(), board.getName(), board.getDescription()))
                .collect(Collectors.toList());
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        return BoardResponseDto.of(board.getId(), board.getName(), board.getDescription());
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
}
