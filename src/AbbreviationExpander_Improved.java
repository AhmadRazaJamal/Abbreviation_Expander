import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander_Improved {

    static HashMap<String, String> abbrMap;
    static Scanner scanner;

    public static void main(String[] args) {

        // Initialize the HashMap
        abbrMap = new HashMap<String, String>();


        // Adding a few abbreviations to the map

        try {
            String[] splitArr ;
            BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
            String line = br.readLine();
            while (line != null) {
                    splitArr = line.split("\\s+", 2);
                    abbrMap.put(splitArr[0], splitArr[1]);
                    line = br.readLine();
            }

            br = new BufferedReader(new FileReader("lingo.txt"));
            line = br.readLine();
            while (line != null) {
                    splitArr = line.split("\\s+", 2);
                    abbrMap.put(splitArr[0], splitArr[1]);
                    line = br.readLine();
            }

            br.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }


        // Initializing the scanner
        scanner = new Scanner(System.in);

        System.out.println("Enter text: ");
        // Getting input and converting to upper case

        String input = scanner.nextLine();

        String[] enteredTextArr = input.split(" ");
        boolean flag = true ;
        // Checking if the map contains the entered abbreviation

        for(int i = 0 ; i < enteredTextArr.length ; i++ ) {
            if (abbrMap.containsKey(enteredTextArr[i])) {

                // displaying the translation
                System.out.print(abbrMap.get(enteredTextArr[i])+" ");
            }
            else
            {
                System.out.print(enteredTextArr[i]+" ") ;
            }
        }

    }
}
