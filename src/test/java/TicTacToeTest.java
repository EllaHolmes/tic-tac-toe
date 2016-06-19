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
        when(board.continueGame()).thenReturn(true,true,false);
        ticTacToe.playGame();
        verify(playerTwo).move();
    }

    @Test
    public void shouldMarkBoardAfterPlayersMove(){
        when(board.continueGame()).thenReturn(true, false);
        when(board.isMarkedAt(anyInt())).thenReturn(false);

        ticTacToe.playGame();
        verify(board, atLeast(1)).placeMark(anyInt(), anyString());
    }

    @Test
    public void shouldPromptPlayerOneToMoveAgainWhenLocationIsAlreadyMarked(){
        when(board.continueGame()).thenReturn(true, false);
        when(board.isMarkedAt(anyInt())).thenReturn(true, false);
        ticTacToe.playGame();
        verify(playerOne, atLeast(2)).move();
    }

    @Test
    public void shouldPromptPlayerTwoToMoveAgainWhenLocationIsAlreadyMarked(){
        when(board.continueGame()).thenReturn(true,true, false);
        when(board.isMarkedAt(anyInt())).thenReturn(true, false, true, true, false);
        ticTacToe.playGame();
        verify(playerTwo, atLeast(2)).move();
    }

    @Test
    public void shouldRepeatPlayerMovesWhenGameShouldContinue() throws IOException {
        when(board.continueGame()).thenReturn(true,true,false);
        InOrder inOrder = inOrder(playerOne, playerTwo);
        ticTacToe.playGame();

        inOrder.verify(playerOne).move();
        inOrder.verify(playerTwo).move();
    }

    @Test
    public void shouldStopPlayingWhenBoardIsFull(){
        when(board.isBoardFull()).thenReturn(true);
        when(board.continueGame()).thenReturn(true, false);
        ticTacToe.playGame();
        verifyZeroInteractions(playerTwo);
    }

    @Test
    public void shouldTellThatPlayerWonWhenThreeOfAKind(){
        when(board.continueGame()).thenReturn(true);
        when(board.threeOfAKind()).thenReturn(true);
        ticTacToe.playGame();
        verify(playerOne).playerWon();
    }
}