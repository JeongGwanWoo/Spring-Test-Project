package jkwhi.firstproject.service;

import jkwhi.firstproject.domain.Board;
import jkwhi.firstproject.domain.BoardStatus;
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

    @Transactional
    public void updateBoard(Long boardId, String name, String title, String content) {
        Board findBoard = boardRepository.findOne(boardId);
        findBoard.setId(boardId);
        findBoard.setName(name);
        findBoard.setTitle(title);
        findBoard.setContent(content);
    }

    @Transactional
    public void deleteBoard(Long boardId) {

        Board findBoard = boardRepository.findOne(boardId);
        findBoard.setStatus(BoardStatus.DELETE);
//        boardRepository.deleteOne(boardRepository.findOne(boardId));
    }
}
