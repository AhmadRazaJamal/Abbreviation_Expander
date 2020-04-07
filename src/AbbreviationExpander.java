import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander {

    static ArrayList<String> englishDic ;
    static ArrayList<String> lingoDic ;
    static Scanner scanner;

    public static void main(String[] args) {

        // Initialize the ArrayList
        englishDic = new ArrayList<>();
        lingoDic=  new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
            String line = br.readLine();
            while (line != null) {
                englishDic.add(line);
                line = br.readLine();
            }

            br = new BufferedReader(new FileReader("lingo.txt"));
            line = br.readLine();
            while (line != null) {
                lingoDic.add(line);
                line = br.readLine();
            }

            br.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }

        // Adding abbreviations to the map

        // Initializing the scanner
        scanner = new Scanner(System.in);

        System.out.println("Enter text: ");
        // Getting input and converting to upper case

        String input = scanner.nextLine();

        String[] enteredTextArr = input.split(" ");
        String[] splitArr ;
        boolean flag = true ;
        // Checking if the map contains the entered abbreviation

        for(int i = 0 ; i < enteredTextArr.length ; i++ ) {
            for(int j = 0 ; j < englishDic.size() ; j++){
                splitArr = englishDic.get(j).split("\\s+",2);
                if (splitArr[0].equalsIgnoreCase(enteredTextArr[i])) {
                    // displaying the translation
                    System.out.print(splitArr[1]+" ");
                    flag = false ;
                    break;
                }
            }
            if(flag){
                for(int k = 0 ; k < lingoDic.size() ; k++){
                    splitArr = lingoDic.get(k).split("\\s+",2);
                    if (splitArr[0].equalsIgnoreCase(enteredTextArr[i])) {
                        // displaying the translation
                        System.out.print(splitArr[1]+" ");
                        flag = false ;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.print(enteredTextArr[i] + " ");
            }
            flag = true ;
        }
    }
}