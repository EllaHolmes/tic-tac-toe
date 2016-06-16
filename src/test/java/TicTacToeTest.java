import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private PrintStream printStream;
    private TicTacToe ticTacToe;
    private BufferedReader reader;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        ticTacToe = new TicTacToe(board, reader, printStream);
    }

    @Test
    public void shouldPrintBoardWhenTicTacToeStarts(){
        ticTacToe.playGame();
        verify(board).printBoard();
    }
    
    @Test
    public void shouldPromptForInputWhenFirstPlayersTurn(){
        ticTacToe.playGame();
        verify(printStream).println("Player 1 : please enter a number");
    }

    @Test
    public void shouldPrintBoardAgainWhenUserInputsNumber() throws IOException {
        when(reader.readLine()).thenReturn("5");
        ticTacToe.playGame();
        verify(board).changeBoard(5,1);
    }

    @Test
    public void shouldPromptForInputWhenSecondPlayersTurn() throws IOException {
        when(reader.readLine()).thenReturn("5");
        ticTacToe.playGame();
        verify(printStream).println("Player 2 : please enter a number");
    }

    @Test
    public void shouldPrintBoardWhenPlayerTwoPlays() throws IOException {
        when(reader.readLine()).thenReturn("5", "9");
        ticTacToe.playGame();
        verify(board).changeBoard(9,2);
    }

    @Ignore
    public void shouldAllowUserToEnterAgainWhenSlotOnBoardIsTaken() throws IOException {
        when(reader.readLine()).thenReturn("5", "5");
        ticTacToe.playGame();
        verify(board, times(2)).isFullAt(5);
    }


}