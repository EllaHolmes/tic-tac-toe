import java.io.PrintStream;

public class TicTacToeGame {

    private Board board;
    private Player playerOne;
    private Player playerTwo;


    public TicTacToeGame(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void playGame() {
        board.drawBoard();

        while (board.continueGame()) {
            playerMove(playerOne);
            playerMove(playerTwo);
        }
    }

    public void playerMove(Player player){
        int locationOfMove = 0;
        do{
            locationOfMove = player.move();
        }while(board.isMarkedAt(locationOfMove));
        board.placeMark(locationOfMove, player.playerNumber);

        board.drawBoard();
    }
}