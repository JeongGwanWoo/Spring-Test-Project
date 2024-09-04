package jkwhi.firstproject.repository;

import jakarta.persistence.EntityManager;
import jkwhi.firstproject.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        if (board.getId() == null) {
            log.info("DB 저장 됐음.");
            em.persist(board);
        } else {
            log.info("DB 저장 이상함?");
            em.merge(board);
        }
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board as b",Board.class).getResultList();
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }
}
