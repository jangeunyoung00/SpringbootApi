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
    @PutMapping(value = "/{id}")
    public String putBoard(@PathVariable int id,
                           @RequestBody BoardDTO boardDTO) throws Exception {
        log.debug("id: " + id);
        return boardService.putBoard(id, boardDTO);
    }

    /* mission */
    // 글 읽기
    // 요청URL은 GET http://localhost:8080/board/{id}
    @GetMapping(value = "/{id}")
    public ApiResponse<BoardDTO> getBoardById(@PathVariable int id) throws Exception {
        return boardService.getBoardById(id);
    }

    // 글 삭제
    // isDeleted : Y로 업데이트 시킴.
    // 요청URL은 DELETE http://localhost:8080/board/{id}
    @DeleteMapping(value = "/{id}")
    public ApiResponse<BoardDTO> updateIsDelBoardById(@PathVariable int id) throws Exception {
        return boardService.updateIsDelBoardById(id);
    }
}