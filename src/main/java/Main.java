import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main( String args[]){
        PrintStream printStream = new PrintStream(System.out);

        List<String> boardArray = new ArrayList(9);
        for(int i = 0; i < 9; i++){
            boardArray.add( (i+1) + "" );
        }

        List<SetOfThree> listOfSets = new ArrayList<SetOfThree>();
        listOfSets.add(new SetOfThree(0,1,2));
        listOfSets.add(new SetOfThree(3,4,5));
        listOfSets.add(new SetOfThree(6,7,8));

        listOfSets.add(new SetOfThree(0,3,6));
        listOfSets.add(new SetOfThree(1,4,7));
        listOfSets.add(new SetOfThree(2,5,8));

        listOfSets.add(new SetOfThree(0,4,8));
        listOfSets.add(new SetOfThree(3,4,6));


        Board board = new Board(boardArray, listOfSets, printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Input userInput = new Input(reader);
        Player playerOne = new Player(userInput, 1, "X", printStream);
        Player playerTwo = new Player(userInput, 2, "O",printStream);

        new TicTacToeGame(board, playerOne, playerTwo).playGame();
    }
}
