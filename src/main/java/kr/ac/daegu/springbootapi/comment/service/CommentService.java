package kr.ac.daegu.springbootapi.comment.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentService {
    
    public final BoardDAO boardDAO;

    public static BoardDTO postBoard(BoardDTO boardDTO) {
        return boardDTO;
    }

    public static String putComment(int id, BoardDTO boardDTO) {
        return null;
    }

    public List<BoardDTO> getBoard() { return boardDAO.getCommentList();}

    public BoardDTO postComment( BoardDTO boardDTO) throws Exception{
        log.debug((Marker) boardDTO,toString());

        // Inserted Date, Inserted Time 정의
        boardDTO.setWriteDate(LocalDate.now());
        boardDTO.setWriteTime(LocalTime.now());

        int insertedRowCount = boardDAO.postBoard(boardDTO);
        if(insertedRowCount >0){

            return boardDTO;
        } else{
            throw new Exception("failed to insert board data");
        }
        
    }
}
