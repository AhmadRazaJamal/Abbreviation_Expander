import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AbbreviationExpander {

    static ArrayList<String> englishDic ;
    static ArrayList<String> lingoDic ;
    static Scanner scanner;
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String RESET = "\033[0m";  // Text Reset

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

        try {
            System.out.print("Enter the file name with extension : ");
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());

            input = new Scanner(file);

            String[] enteredTextArr;
            String[] splitArr;
            String[] splitTwitterArr;
            boolean flag = true;


            while (input.hasNextLine()) {
                String line = input.nextLine();
                enteredTextArr = line.split(",",5);

                try {
                    splitTwitterArr = enteredTextArr[4].substring(1, enteredTextArr[4].length() - 1).split(" ");
                }
                catch (Exception e){
                    continue;
                }

                for (int i = 0; i < splitTwitterArr.length; i++) {
                    for (int j = 0; j < englishDic.size(); j++) {
                        splitArr = englishDic.get(j).split("\\s+", 2);
                        if (splitArr[0].equalsIgnoreCase(splitTwitterArr[i])) {
                            // displaying the translation
                            System.out.print( ANSI_WHITE_BACKGROUND + splitArr[1] + " ");
                            System.out.print(RESET);
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int k = 0; k < lingoDic.size(); k++) {
                            splitArr = lingoDic.get(k).split("\\s+", 2);
                            if (splitArr[0].equalsIgnoreCase(splitTwitterArr[i])) {
                                // displaying the translation
                                System.out.print(ANSI_GREEN_BACKGROUND +splitArr[1] + " ");
                                System.out.print(RESET);
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        System.out.print(RESET+splitTwitterArr[i] + " ");
                    }
                    flag = true;
                }
                System.out.println();
            }
            input.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }
        // Checking if the map contains the entered abbreviation
    }
}