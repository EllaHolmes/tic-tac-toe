import org.junit.Before;
import org.junit.Ignore;
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

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintSlotNumbersWhenBoardIsPrinted(){
        board.printBoard();
        verify(printStream).println("1|2|3|\n4|5|6|\n7|8|9|\n");
    }

    @Test
    public void shouldChangeBoardWithXAtSlot2WhenPlayerOneInputsTwo() throws IOException {
        board.changeBoard(2,1);
        verify(printStream).println("1|X|3|\n4|5|6|\n7|8|9|\n");
    }
    
    @Test
    public void shouldRejectBoardChangesWhenSlotIsAlreadyFilled(){
        board.changeBoard(4,1);
        boolean fullAt = board.isFullAt(4);
        assertEquals(true, fullAt);
        verify(printStream).println("Location already taken");

    }



}