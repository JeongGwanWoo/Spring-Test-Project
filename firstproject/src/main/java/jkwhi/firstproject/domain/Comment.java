package jkwhi.firstproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;

    private String comment;
}
