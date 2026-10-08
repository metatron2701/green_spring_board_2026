package com.green.spring_board.service;

import com.green.spring_board.dto.CommentCreateRequest;
import com.green.spring_board.entity.Board;
import com.green.spring_board.entity.Comment;
import com.green.spring_board.entity.User;
import com.green.spring_board.exceptions.ResourceNotFoundException;
import com.green.spring_board.repository.BoardRepository;
import com.green.spring_board.repository.CommentRepository;
import com.green.spring_board.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private BoardRepository boardRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public void createComment(int boardId, Integer userId, CommentCreateRequest commentCreateRequest) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isEmpty()) {
            throw new ResourceNotFoundException("존재하지 않는 게시글입니다.");
        }

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("존재하지 않는 유저입니다.");
        }

        Board board = optionalBoard.get();
        User user = optionalUser.get();

        Comment comment = new Comment();
        comment.setBoard(board);
        comment.setUser(user);
        comment.setContent(commentCreateRequest.getContent());
        commentRepository.save(comment);
    }
}
