import java.util.List;

public class SetOfThree {

    private final int arrayReferenceOne;
    private final int arrayReferenceTwo;
    private final int arrayReferenceThree;

    public SetOfThree(int arrayReferenceOne, int arrayReferenceTwo, int arrayReferenceThree ) {
        this.arrayReferenceOne = arrayReferenceOne;
        this.arrayReferenceTwo = arrayReferenceTwo;
        this.arrayReferenceThree = arrayReferenceThree;
    }

    public boolean isThreeOfKind(List<String> boardArray) {
        String valueOne = boardArray.get(arrayReferenceOne);
        String valueTwo = boardArray.get(arrayReferenceTwo);
        String valueThree =boardArray.get(arrayReferenceThree);

        if(valueOne.equals(valueTwo) && valueOne.equals(valueThree)){
            return true;
        }
        return false;
    }
}
