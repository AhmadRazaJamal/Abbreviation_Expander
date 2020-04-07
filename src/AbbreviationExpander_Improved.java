import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander_Improved {

    static HashMap<String, String> englishDicMap;
    static HashMap<String, String> lingoDicMap;
    static Scanner scanner;
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String RESET = "\033[0m";  // Text Reset

    public static void main(String[] args) {

        // Initialize the HashMap
        englishDicMap = new HashMap<String, String>();
        lingoDicMap = new HashMap<String, String>();


        // Adding a few abbreviations to the map

        try {
            String[] splitArr ;
            BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
            String line = br.readLine();
            while (line != null) {
                    splitArr = line.split("\\s+", 2);
                    englishDicMap.put(splitArr[0], splitArr[1]);
                    line = br.readLine();
            }

            br = new BufferedReader(new FileReader("lingo.txt"));
            line = br.readLine();
            while (line != null) {
                    splitArr = line.split("\\s+", 2);
                    lingoDicMap.put(splitArr[0], splitArr[1]);
                    line = br.readLine();
            }

            br.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }

        try {
            System.out.print("Enter the file name with extension : ");

            // Initializing the scanner
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());

            input = new Scanner(file);
            String[] enteredTextArr ;
            String[] splitTwitterArr;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                enteredTextArr = line.split(",",5);
                splitTwitterArr = enteredTextArr[4].substring(1,enteredTextArr[4].length()-1).split(" ");
                // Checking if the map contains the entered abbreviation

                for(int i = 0 ; i < splitTwitterArr.length ; i++ ) {
                    if (englishDicMap.containsKey(splitTwitterArr[i].toLowerCase())) {
                     // displaying the translation
                     System.out.print(ANSI_WHITE_BACKGROUND + englishDicMap.get(splitTwitterArr[i].toLowerCase())+" ");
                     System.out.print(RESET);
                    }
                    else if(lingoDicMap.containsKey(splitTwitterArr[i].toLowerCase()))
                    {
                     System.out.print(ANSI_GREEN_BACKGROUND+lingoDicMap.get(splitTwitterArr[i].toLowerCase())+" ");
                     System.out.print(RESET);
                    }
                    else {
                    System.out.print(RESET+splitTwitterArr[i]+" ");
                }
            }
            System.out.println();
        }
        input.close();
    }
        catch (IOException e){
        System.out.print("Something went wrong while processing file");
        e.printStackTrace();
    }

    }
}
