package community.backend.domain.board.domain;

import community.backend.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String name;

    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "board")
    private List<Article> articles = new ArrayList<Article>();

    @Builder
    public Board(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}