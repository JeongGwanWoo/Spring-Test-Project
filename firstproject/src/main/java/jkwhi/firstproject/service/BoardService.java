package jkwhi.firstproject.service;

import jkwhi.firstproject.domain.Board;
import jkwhi.firstproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public List<Board> findPosts() {
        return boardRepository.findAll();
    }

    public Board findOne(Long boardId) {
        return boardRepository.findOne(boardId);
    }
}
