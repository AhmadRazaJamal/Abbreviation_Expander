import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander_Improved {

    static HashMap<String, String> abbrMap;
    static Scanner scanner;

    public static void main(String[] args) {

        // Initialize the HashMap
        abbrMap = new HashMap<String, String>();


        // Adding a few abbreviations to the map

        abbrMap.put("LOL", "Laughing out loud");
        abbrMap.put("IDK", "I don't know");
        abbrMap.put("BFF", "Best friends forever");
        abbrMap.put("IMHO", "In my humble opinion");


        // Initializing the scanner
        scanner = new Scanner(System.in);

        System.out.println("Enter text: ");
        // Getting input and converting to upper case

        String input = scanner.nextLine();

        String[] enteredTextArr = input.split(" ");

        // Checking if the map contains the entered abbreviation

        for(int i = 0 ; i < enteredTextArr.length ; i++ ) {
            if (abbrMap.containsKey(enteredTextArr[i].toUpperCase())) {

                // displaying the translation
                System.out.print(abbrMap.get(enteredTextArr[i].toUpperCase())+" ");

            }
            else
            {
                System.out.print(enteredTextArr[i]+" ") ;
            }
        }

    }
}
