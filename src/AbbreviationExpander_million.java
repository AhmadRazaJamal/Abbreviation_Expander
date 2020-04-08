import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AbbreviationExpander_million {

    static HashMap<String, String> englishDicMap; // A Hashmap dictionary that stores the english dictionary
    static HashMap<String, String> lingoDicMap; // A Hashmap dictionary that stores common lingo words / acronym words
    static Scanner scanner;
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // Green background code
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";  // White background code
    public static final String RESET = "\033[0m";  // Text Reset

    public static void main(String[] args) {

        // Initialize the HashMaps
        englishDicMap = new HashMap<String, String>();
        lingoDicMap = new HashMap<String, String>();

        /* Change this to control number of tweets you want to expand
        *
        */
        int amountOfTweets = 100000;
        String[] tweetsArr = new String[amountOfTweets];

        try {
            String[] splitArr ;

            // Fill the english dictionary HashMap
            BufferedReader br = new BufferedReader(new FileReader("englishDict.txt"));
            String line = br.readLine();
            while (line != null) {
                splitArr = line.split("\\s+", 2);
                englishDicMap.put(splitArr[0], splitArr[1]);
                line = br.readLine();
            }

            // Fill the lingo dictionary HashMap
            br = new BufferedReader(new FileReader("lingo.txt"));
            line = br.readLine();
            while (line != null) {
                splitArr = line.split("\\s+", 2);
                lingoDicMap.put(splitArr[0], splitArr[1]);
                line = br.readLine();
            }
            br = new BufferedReader(new FileReader("millionTweet.txt"));
            for(int i = 0; i < amountOfTweets; i++){
                tweetsArr[i] = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }

        String[] splitTwitterArr;

        double t1 = System.currentTimeMillis(); // Get some time values || Start point

        for(int k = 0; k < amountOfTweets; k++) {

            /* If the tweet comment is faulty or the line read isn't a tweet record then skip

             */
            try {
                // Split the tweet comment into array elements on spaces
                splitTwitterArr = tweetsArr[k].split(" ");
            } catch (Exception e) {
                continue;
            }
            // Checking if the map contains the entered abbreviation

            for (int i = 0; i < splitTwitterArr.length; i++) {
                // Go through the tweet comment split array on each word
                if (englishDicMap.containsKey(splitTwitterArr[i].toLowerCase())) {
                    // If the word was in the english dictionary then print
                    System.out.print(ANSI_WHITE_BACKGROUND + englishDicMap.get(splitTwitterArr[i].toLowerCase()) + " ");
                    System.out.print(RESET);
                } else if (lingoDicMap.containsKey(splitTwitterArr[i].toLowerCase())) {
                    // If the word was in the lingo dictionary its not an acronym
                    System.out.print(ANSI_GREEN_BACKGROUND + lingoDicMap.get(splitTwitterArr[i].toLowerCase()) + " ");
                    System.out.print(RESET);
                } else {
                    // If word is neither in english dictionary and acronym dictionary then it must be a typo, print as is
                    System.out.print(RESET + splitTwitterArr[i] + " ");
                }
            }
            System.out.println();
        }

    }
}
