package com.green.spring_board.controller;

import com.green.spring_board.dto.ApiResponse;
import com.green.spring_board.dto.CommentCreateRequest;
import com.green.spring_board.exceptions.UnauthenticatedException;
import com.green.spring_board.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping("/board/{boardId}/comment")
    public ResponseEntity<ApiResponse<Void>> createComment(
            @RequestBody CommentCreateRequest commentCreateRequest,
            @PathVariable int boardId,
            HttpServletRequest httpServletRequest
    ){
        HttpSession session = httpServletRequest.getSession(false);
        if(session == null || session.getAttribute("userId") == null) {
            throw new UnauthenticatedException("로그인이 필요합니다.");
        }

        int userId = (int) session.getAttribute("userId");
        commentService.createComment(boardId, userId, commentCreateRequest);

        return ResponseEntity.ok(ApiResponse.ok());
    }
}
