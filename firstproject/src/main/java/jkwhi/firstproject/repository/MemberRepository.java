package jkwhi.firstproject.repository;

import jakarta.persistence.EntityManager;
import jkwhi.firstproject.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

}
