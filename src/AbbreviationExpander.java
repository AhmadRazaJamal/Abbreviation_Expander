import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander {

        static ArrayList<String> abbrDic ;
        static Scanner scanner;

        public static void main(String[] args) {

            // Initialize the ArrayList
            abbrDic = new ArrayList<>();

            try {
                BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
                String line = br.readLine();
                while (line != null) {
                    abbrDic.add(line);
                    line = br.readLine();
                }

                 br = new BufferedReader(new FileReader("lingo.txt"));
                line = br.readLine();
                while (line != null) {
                    abbrDic.add(line);
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
                for(int j = 0 ; j < abbrDic.size() ; j++){
                    splitArr = abbrDic.get(j).split("\\s+",2);
                    if (splitArr[0].equalsIgnoreCase(enteredTextArr[i])) {
                        // displaying the translation
                        System.out.print(splitArr[1]+" ");
                        flag = false ;
                        break;
                    }
                }
                if(flag == true) {
                    System.out.print(enteredTextArr[i] + " ");
                }
                flag = true ;
            }
        }
}
