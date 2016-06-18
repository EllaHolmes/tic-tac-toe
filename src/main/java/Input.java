import java.io.BufferedReader;
import java.io.IOException;

public class Input {


    private BufferedReader reader;

    public Input(BufferedReader reader) {
        this.reader = reader;
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
