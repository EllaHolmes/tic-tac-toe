import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private Board board;
    private PrintStream printStream;
    private String[] boardArray;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardArray = new String[9];
        board = new Board(printStream, boardArray);
    }

    @Test
    public void shouldPrintSlotNumbersWhenBoardIsPrinted(){
        board.drawBoard();
        verify(printStream).println("1|2|3|\n4|5|6|\n7|8|9|\n");
    }

    @Test
    public void shouldChangeBoardWithXAtSlot2WhenPlayerOneInputsTwo() throws IOException {
        board.placeMark(2,1);
        board.drawBoard();
        assertEquals("X", boardArray[1]);
        assertEquals(null, boardArray[0]);
        verify(printStream).println("1|X|3|\n4|5|6|\n7|8|9|\n");
    }
    
    @Test
    public void shouldRejectBoardChangesWhenSlotIsAlreadyFilled(){
        board.placeMark(4,1);
        boolean fullAt = board.isMarkedAt(4);
        assertEquals(true, fullAt);
    }

    @Test
    public void shouldPrintMessageWhenBoardIsMarkedAtLocation(){
        board.placeMark(5,1);
        boolean answer = board.isMarkedAt(5);
        assertEquals(true, answer);
        assertEquals("X", boardArray[4]);
        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldNotifyUserLocationOccupiedWhenBoardIsFull(){
//        when(input.listenForInput()).thenReturn(3);
//        when(board.isMarkedAt(3)).thenReturn(true, false);
//        ticTacToe.letThisUserPlay(1);
//        verify(printStream).println("Location already taken");
    }



}