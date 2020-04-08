import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* Please use data sets provided and read readme file

 */
public class AbbreviationExpander {

    static ArrayList<String> englishDic ; // An array dictionary that stores the english dictionary
    static ArrayList<String> lingoDic ; // An array dictionary that stores common lingo words / acronym words

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // Green background code
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // White background code
    public static final String RESET = "\033[0m";  // Text Reset

    public static void main(String[] args) {

        // Initialize the ArrayLists
        englishDic = new ArrayList<>();
        lingoDic=  new ArrayList<>();

        // Fill the english dictionary
        try {
            BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
            String line = br.readLine();
            while (line != null) {
                englishDic.add(line);
                line = br.readLine();
            }

            // Fill the lingo dictionary
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

        try {
            System.out.println("Enter the file name with extension : ");
            System.out.println("[To run millionTweet.txt, run AbbreviationExpander_million class and read README file] ");

            Scanner input = new Scanner(System.in); // Initializing the scanner
            File file = new File(input.nextLine());
            input = new Scanner(file);

            String[] enteredTextArr; // Array that stores the split from currrent file read
            String[] splitArr; // Array that stores the split from english or lingo dictionary
            String[] splitTwitterArr; // Array that stores the split from twitter comment
            boolean flag = true;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                enteredTextArr = line.split(",",5);
                // Split first read line from file into components as [topic, feedback, id, date, tweet comment]

                /* If the tweet comment is faulty or the line read isn't a tweet record then skip

                 */
                try {
                    splitTwitterArr = enteredTextArr[4].substring(1, enteredTextArr[4].length() - 1).split(" ");
                    // Split the tweet comment into array elements on spaces
                }
                catch (Exception e){
                    continue;
                }

                for (int i = 0; i < splitTwitterArr.length; i++) {
                    // Go through the tweet comment split array on each word
                    for (int j = 0; j < englishDic.size(); j++) {
                        splitArr = englishDic.get(j).split("\\s+", 2);
                        // Grab each word from English dictionary and compare
                        if (splitArr[0].equalsIgnoreCase(splitTwitterArr[i])) {
                            // displaying the translation
                            System.out.print( ANSI_WHITE_BACKGROUND + splitArr[1] + " ");
                            System.out.print(RESET);

                            // If the word was in the english dictionary its not an acronym
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        // Check if word is in acronym/lingo dictionary
                        for (int k = 0; k < lingoDic.size(); k++) {
                            splitArr = lingoDic.get(k).split("\\s+", 2);
                            // Grab each word from English dictionary and compare
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
                        // If word is neither in english dictionary and acronym dictionary then it must be a typo
                        System.out.print(RESET+splitTwitterArr[i] + " ");
                    }
                    flag = true;
                    // Reset flag for next iteration
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