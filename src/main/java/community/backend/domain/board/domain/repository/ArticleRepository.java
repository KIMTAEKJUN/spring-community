package community.backend.domain.board.domain.repository;

import community.backend.domain.board.domain.Article;
import community.backend.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByBoardOrderByCreatedAtDesc(Board board);

    Optional<Article> findByIdAndBoard(Long id, Board board);
}
