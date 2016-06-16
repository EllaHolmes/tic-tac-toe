import java.io.PrintStream;

public class Board {

    private PrintStream printStream;
    private String[] board = new String[9];

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }


    public void printBoard() {
        String visualBoard = "";
        for(int i = 0; i < board.length; i++){
            if( board[i] == null){
                visualBoard += i+1 + "|";
            }else{
                visualBoard += board[i]+ "|";
            }

            if((i+1) % 3 == 0){
                visualBoard+="\n";
            }
        }
        printStream.println(visualBoard);
    }

    public void changeBoard(int slot, int player) {
        if(player == 1){
            board[slot-1] = "X";
        }else{
            board[slot-1] = "O";
        }
        printBoard();

    }

    public boolean isFullAt(int inputNumber) {
        if(board[inputNumber-1] != null){
            return true;
        }
        return false;
    }
}
