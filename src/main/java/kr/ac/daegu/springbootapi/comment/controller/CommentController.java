package kr.ac.daegu.springbootapi.comment.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.comment.service.CommentService;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/board")
public class CommentController {

    public final CommentService commentService;

    @PostMapping(value = "/")
    public ApiResponse<BoardDTO> postCommentList(@RequestBody CommentDTO commentDTO) throws Exception{
        CommentDTO dto = commentService.postComment(commentDTO);
        return new ApiResponse(true, dto);
    }
}
