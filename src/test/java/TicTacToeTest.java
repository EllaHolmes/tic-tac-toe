import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.IOException;
import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private TicTacToeGame ticTacToe;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);

        ticTacToe = new TicTacToeGame(board, playerOne, playerTwo);
    }

    @Test
    public void shouldPrintBoardWhenTicTacToeStarts(){
        ticTacToe.playGame();
        verify(board, atLeast(1)).drawBoard();
    }

    @Test
    public void shouldPrintBoardAgainWhenPlayerMoves() throws IOException {
        when(board.continueGame()).thenReturn(true, false);
        InOrder inOrder = inOrder(board, playerOne);
        ticTacToe.playGame();

        inOrder.verify(playerOne, atLeast(1)).move();
        inOrder.verify(board, atLeast(1)).drawBoard();
    }

    @Test
    public void shouldPromptForInputWhenSecondPlayersTurn() throws IOException {
        when(board.continueGame()).thenReturn(true,false);
        ticTacToe.playGame();
        verify(playerTwo).move();
    }

    @Test
    public void shouldMarkBoardAfterPlayersMove(){
        ticTacToe.playGame();
        verify(board, atLeast(1)).placeMark(anyInt(), anyInt());
    }

    @Test
    public void shouldPromptPlayerOneToMoveAgainWhenLocationIsAlreadyMarked(){
        when(board.isMarkedAt(anyInt())).thenReturn(true, false);
        ticTacToe.playGame();
        verify(playerOne, atLeast(2)).move();
    }

    @Test
    public void shouldPromptPlayerTwoToMoveAgainWhenLocationIsAlreadyMarked(){
        when(board.isMarkedAt(anyInt())).thenReturn(true, false, true, false);
        ticTacToe.playGame();
        verify(playerTwo, atLeast(2)).move();
    }



    @Ignore
    public void shouldDrawBoardWhenPlayerTwoPlays() throws IOException {
        when(board.continueGame()).thenReturn(true,false);
        InOrder inOrder = inOrder(board, playerTwo);
        ticTacToe.playGame();

        inOrder.verify(board, atLeast(1)).drawBoard();
        inOrder.verify(playerTwo).move();
        inOrder.verify(board, atLeast(1)).drawBoard();
    }

    @Ignore
    public void shouldBePlayer1TurnAfterPlayer2Turn(){
        when(board.continueGame()).thenReturn(true,true,false);
        InOrder inOrder = inOrder(playerOne, playerTwo);
        ticTacToe.playGame();

        inOrder.verify(playerOne).move();
        inOrder.verify(playerTwo).move();
        inOrder.verify(playerOne).move();
    }
}