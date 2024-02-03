package community.backend.domain.board.domain;

import community.backend.domain.user.user.domain.User;
import community.backend.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "article")
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String author;

    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String title;

    @Size(min = 1, max = 500)
    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @Builder
    public Article(Long id, String author, String title, String content, User user, Board board) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.user = user;
        this.board = board;
    }

    public void updateArticle(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // public Long getUserId() {
    //     return User.builder().id(user.getId()).build().getId();
    // }

    public Long getBoardId() {
        return board.getId();
    }

    public String getBoardName() {
        return board.getName();
    }
}
