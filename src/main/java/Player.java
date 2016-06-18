import java.io.PrintStream;

public class Player {

    private final Input userInput;
    public final int playerNumber;
    private final String mark;
    private PrintStream printStream;

    public Player(Input userInput, int playerNumber, String mark, PrintStream printStream) {
        this.userInput = userInput;
        this.playerNumber = playerNumber;
        this.mark = mark;
        this.printStream = printStream;
    }

    public int move(){
        printStream.println("Player "+ playerNumber +" : please enter a number");
        return userInput.listenForInput();
    }
}
