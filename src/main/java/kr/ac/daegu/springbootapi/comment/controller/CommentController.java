package kr.ac.daegu.springbootapi.comment.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.comment.service.CommentService;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/boardId")
public class CommentController {

    public final CommentService commentService;

    @GetMapping(value = "/")
    public ApiResponse<BoardDTO> postBoard(@RequestBody BoardDTO boardDTO) throws Exception{
        BoardDTO dto = CommentService.postBoard(boardDTO);
        return new ApiResponse<BoardDTO>(true, dto);
    }
    @PutMapping(value = "/{boardId}")
    public String putBoard(@PathVariable int id,
                           @RequestBody BoardDTO boardDTO) throws Exception {
        log.debug("id: " + id);
        return CommentService.putComment(id, boardDTO);
    }
}
