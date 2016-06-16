import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main( String args[]){
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        new TicTacToe(board, reader, printStream).playGame();
    }
}
