package kr.ac.daegu.springbootapi.board.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.board.service.BoardService;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/board")
public class BoardController {

    public final BoardService boardService;

    @GetMapping(value = "/")
    public ApiResponse<BoardDTO> getBoardList() {
        List<BoardDTO> list = boardService.getBoardList();
        return new ApiResponse(true,list);
    }
    /* mission */
    // postman에서 GET http://localhost:8080/board/ 요청 날려서
    // DB의 board 테이블 데이터 모두 가져와서 json return 해보기.
    @PostMapping(value = "/")
    public ApiResponse<BoardDTO> postBoard(@RequestBody BoardDTO boardDTO) throws Exception {
        BoardDTO dto = boardService.postBoard(boardDTO);
        return new ApiResponse<>(true, dto);
    }
}