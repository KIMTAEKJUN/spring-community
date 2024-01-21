package community.backend.domain.board.domain.repository;

import community.backend.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findById(Long id);

    Optional<Board> findByName(String name);

    List<Board> findAllByOrderByCreatedAtDesc();
}
