import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {

    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;

    public TicTacToe(Board board, BufferedReader reader, PrintStream printStream) {
        this.board = board;
        this.reader = reader;
        this.printStream = printStream;
    }

    public void playGame() {
        board.printBoard();
        letThisUserPlay(1);
        letThisUserPlay(2);
    }

    private void letThisUserPlay(int player) {
        printStream.println("Player "+ player +" : please enter a number");
        int slot = askForUserInput();
        board.changeBoard(slot, player);

    }

    private int askForUserInput() {
        int slot = listenForInput();
        while(board.isFullAt(slot)){
            printStream.println("Location already taken");
            slot = listenForInput();
        }
        return slot;
    }

    public int listenForInput(){
        String input = "0";
        int inputNumber = 0;

        try {
            input = reader.readLine();

            try{
                inputNumber = Integer.parseInt(input);

            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }

        return inputNumber;

    }
}
