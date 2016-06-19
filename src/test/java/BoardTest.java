import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;
    private List<String> boardArray;
    private List<SetOfThree> listOfSets;

    @Before
    public void setUp() throws Exception {

        printStream = mock(PrintStream.class);
        boardArray = new ArrayList<String>(9);
        for(int i = 0; i < 9; i++){
            boardArray.add( (i+1) + "");
        }
        listOfSets = new ArrayList<SetOfThree>();
        listOfSets.add(new SetOfThree(0,1,2));
        board = new Board(boardArray, listOfSets, printStream);
    }

    @Test
    public void shouldPrintSlotNumbersWhenBoardIsPrinted(){
        board.drawBoard();
        verify(printStream).println("1|2|3|\n4|5|6|\n7|8|9|\n");
    }

    @Test
    public void shouldChangeBoardWithXAtSlot2WhenPlayerOneInputsTwo() throws IOException {
        board.placeMark(2,"X");
        board.drawBoard();
        assertEquals("X", boardArray.get(1));
        assertEquals("1", boardArray.get(0));
        verify(printStream).println("1|X|3|\n4|5|6|\n7|8|9|\n");
    }

    @Test
    public void shouldRejectBoardChangesWhenSlotIsAlreadyFilled(){
        board.placeMark(4,"X");
        boolean fullAt = board.isMarkedAt(4);
        assertEquals(true, fullAt);
    }

    @Test
    public void shouldPrintMessageWhenBoardIsMarkedAtLocation(){
        board.placeMark(5,"X");
        boolean answer = board.isMarkedAt(5);
        assertEquals(true, answer);
        assertEquals("X", boardArray.get(4));
        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldReturnTrueWhenArrayBoardHasNoNullValues(){
        for(int i = 0; i <boardArray.size(); i++){
            board.placeMark(i+1, "X");
        }
        board.drawBoard();
        assertEquals(true, board.isBoardFull());
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldReturnFalseWhenArrayBoardHasNullValues(){
        assertEquals(false, board.isBoardFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardHasFullRow(){
        for(int i = 0; i <3; i++){
            board.placeMark(i+1, "X");
        }
        board = new Board(boardArray, listOfSets, printStream);
        assertEquals(true, board.threeOfAKind());
    }
}