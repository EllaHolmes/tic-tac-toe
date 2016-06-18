import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main( String args[]){
        PrintStream printStream = new PrintStream(System.out);
        String[] boardArray = new String[9];
        Board board = new Board(printStream, boardArray);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Input userInput = new Input(reader);
        Player playerOne = new Player(userInput, 1, "X", printStream);
        Player playerTwo = new Player(userInput, 2, "O",printStream);
        new TicTacToeGame(board, playerOne, playerTwo).playGame();
    }
}
