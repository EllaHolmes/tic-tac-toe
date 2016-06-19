import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SetOfThreeTest {

    private SetOfThree setOfThree;
    private List<String> boardArray;

    @Before
    public void setUp(){
        setOfThree = new SetOfThree(0,1,2);
        boardArray = new ArrayList<String>();

    }

    @Test
    public void shouldReturnTrueWhenThereIsThreeOfAKind(){
        boardArray.add("X");
        boardArray.add("X");
        boardArray.add("X");

        boolean gameWon = setOfThree.isThreeOfKind(boardArray);
        assertEquals(true, gameWon);
    }

    @Test
    public void shouldReturnFalseWhenThereIsNotThreeOfAKind(){
        boardArray.add("X");
        boardArray.add("O");
        boardArray.add("X");

        boolean gameWon = setOfThree.isThreeOfKind(boardArray);
        assertEquals(false, gameWon);
    }

}