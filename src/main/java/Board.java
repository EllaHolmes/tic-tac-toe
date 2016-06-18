import java.io.PrintStream;

public class Board {

    private PrintStream printStream;
    private String[] boardArray;

    public Board(PrintStream printStream, String[] boardArray) {
        this.printStream = printStream;
        this.boardArray = boardArray;
    }


    public void drawBoard() {
        String visualBoard = "";
        for(int i = 0; i < boardArray.length; i++){
            if( boardArray[i] == null){
                visualBoard += i+1 + "|";
            }else{
                visualBoard += boardArray[i]+ "|";
            }

            if((i+1) % 3 == 0){
                visualBoard+="\n";
            }
        }
        printStream.println(visualBoard);
    }

    public void placeMark(int slot, int player) {
        if(player == 1){
            boardArray[slot-1] = "X";
        }else{
            boardArray[slot-1] = "O";
        }
    }

    public boolean isMarkedAt(int inputNumber) {
        if(boardArray[inputNumber-1] != null){
            printStream.println("Location already taken");
            return true;
        }
        return false;
    }

    public boolean continueGame() {
        return true;
    }
}

