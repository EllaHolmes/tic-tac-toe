import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    private Input mock;
    private Input input;
    private PrintStream printStream;
    private Player player;

    @Before
    public void setUp() throws Exception {
        mock = mock(Input.class);
        input = mock(Input.class);
        printStream = mock(PrintStream.class);
        player = new Player(input, 1, "X", printStream);
    }

    @Test
    public void shouldPromptForInputWhenPlayersTurn(){
        player.move();
        verify(printStream).println("Player 1 : please enter a number");
    }

    @Test
    public void shouldReceiveUserInputNumberPlayerMoves(){
        player.move();
        verify(input).listenForInput();
    }

    @Test
    public void shouldPrintWinnerMessageWhenPlayerWon(){
        player.playerWon();
        verify(printStream).println("Player 1 Wins!");

    }

}