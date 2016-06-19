import java.io.PrintStream;
import java.util.List;

public class Board {

    private List<String> boardArray;
    private List<SetOfThree> listOfSets;
    private PrintStream printStream;

    public Board(List<String> boardArray, List<SetOfThree> listOfSets, PrintStream printStream) {
        this.boardArray = boardArray;
        this.listOfSets = listOfSets;
        this.printStream = printStream;
    }


    public void drawBoard() {
        String str = "";
        for(int i = 0; i < boardArray.size(); i++){
            str += boardArray.get(i) + "|";

            if((i+1) % 3 == 0){
                str += "\n";
            }
        }
        printStream.println(str);
    }

    public void placeMark(int slot, String mark) {
        boardArray.set( slot -1, mark);
    }

    public boolean isMarkedAt(int inputNumber) {
        String str = boardArray.get(inputNumber-1);
        if( str.equals("X") || str.equals("O")){
            printStream.println("Location already taken");
            return true;
        }
        return false;
    }

    public boolean continueGame() {
        return !isBoardFull() || !threeOfAKind();
    }

    public boolean isBoardFull(){
        for(String str :  boardArray){
            if(!str.equals("X") && !str.equals("O"))
                return false;
        }
        printStream.println("Game is a draw");
        return true;
    }

    public boolean threeOfAKind() {
       for(SetOfThree set : listOfSets){
           if( set.isThreeOfKind(boardArray)){
               return true;
           }
       }
        return false;
    }
}

