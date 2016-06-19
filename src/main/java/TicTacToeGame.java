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
        int count = 1;
        while (board.continueGame()) {
            Player currentPlayer = count % 2 == 1 ? playerOne : playerTwo;
            playerMove(currentPlayer);
            if(board.threeOfAKind()){
                currentPlayer.playerWon();
                break;
            }
            count++;
        }
    }

    public void playerMove(Player player){
        int locationOfMove = 0;
        do{
            locationOfMove = player.move();
        }while(board.isMarkedAt(locationOfMove));
        board.placeMark(locationOfMove, player.mark);

        board.drawBoard();
    }
}