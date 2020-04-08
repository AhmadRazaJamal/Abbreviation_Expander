import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AbbreviationExpander {

        static ArrayList<String> abbrDic ;
        static Scanner scanner;
        @SuppressWarnings("resource")
        public static void main(String[] args) {

            // Initialize the ArrayList
            int amountOfTweets = 200; // Change this to change the amount of tweets you want to parse
            abbrDic = new ArrayList<>();
            String [] tweets= new String[amountOfTweets]; //Used to store individual tweet

            try {
                BufferedReader br = new BufferedReader(new FileReader("twitterSlang.txt"));
                String line = br.readLine();
                while (line != null) {
                    abbrDic.add(line);
                    line = br.readLine();
                }
                br = new BufferedReader(new FileReader("twitterSampleDataset.txt"));
                line = br.readLine();
                for(int i = 0; i < amountOfTweets; i++) {
                	tweets[i] = br.readLine();
                }
                br.close();
            }
            catch (IOException e){
                System.out.print("Something went wrong while processing file");
                e.printStackTrace();
            }

<<<<<<< Updated upstream
             // Adding abbreviations to the map

            // Initializing the scanner
            //scanner = new Scanner(System.in);

            System.out.println("Enter text: ");
            // Getting input and converting to upper case

            //String input = scanner.nextLine();
            double t1 = System.currentTimeMillis(); //Used to determine total time taken | Start point
            for(int k = 0; k < amountOfTweets; k++){
            String[] enteredTextArr = tweets[k].split(" ");
            String[] splitArr ;
            boolean flag = true ;
            // Checking if the map contains the entered abbreviation

            for(int i = 0 ; i < enteredTextArr.length ; i++ ) {
                for(int j = 0 ; j < abbrDic.size() ; j++){
                    splitArr = abbrDic.get(j).split("-",3);
                    System.out.println(splitArr[1]);
                    if (splitArr[0].equals(enteredTextArr[i])) {
                        // displaying the translation
                       // System.out.print(splitArr[1]+" ");
                        flag = false ;
                        break;
=======
            br.close();
        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
        }

        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in); // Initializing the scanner
            File file = new File(input.nextLine());
            input = new Scanner(file);

            double t1 = System.currentTimeMillis(); // Get some time values || Start point

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
>>>>>>> Stashed changes
                    }
                }
                if(flag) {
                    System.out.print(enteredTextArr[i] + " ");
                }
                flag = true ;
            }
<<<<<<< Updated upstream
            System.out.println();
=======

            input.close();

            double t2 = System.currentTimeMillis();
            double totalTime = t2-t1;
            System.out.println();
            System.out.println(totalTime);

        }
        catch (IOException e){
            System.out.print("Something went wrong while processing file");
            e.printStackTrace();
>>>>>>> Stashed changes
        }
            double t2 = System.currentTimeMillis(); //End Point
            double totalTime = t2-t1; //Total Time taken
            System.out.println();

            System.out.println("TOTAL TIME FOR " + amountOfTweets + " IS " + totalTime);
    }
}
