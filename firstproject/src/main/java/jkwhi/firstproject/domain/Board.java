package jkwhi.firstproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String name;
    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardStatus status; // INCLUDE, DELETE

    //==비즈니스 로직=//

}
