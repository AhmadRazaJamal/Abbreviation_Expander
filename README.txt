COSC 320 Project Milestone I – Group 12
Florencia Chomski, Marcus Tam, Paul Zapote, Ahmad Raza Jamal
[ Project Name : Abbreviation Expander ] 

Important !! : 

There are three class files : 

1. Abbreviation Expander : Using just array lists 
2. Abbreviation Expander Improved : Using HashMap implementation 
3. Abbreviation Expander million : Curated particularly for million data sets using still HashMaps

! Reason for a third class/implementation !

Weren't able to find a big enough data set with CSV formatting of more than 1000, 
so we made this implementation just for large amounts of just tweet comments. This class runs 
based on the dataset millionTweets provided with it and the program runs for 10,000 tweets by default
which can be changed by changing the value of variable "amountofTweets" up-to 1 million. The program should 
Work for all cases. 

! Important ! 

The millionTweet.txt being a different formatting doesn't work for Abbreviation Expander Improved, use on the third class 

Input :

Both the implementations use English Dictionary and Lingo Dictionary obtained from an online open source 

Use the input data sets provided as it has been particularly curated for this program as we needed
to filter through the CSV files for multiple tweets. It should work for other documents too, but would need tweaking.

Output:

The output is displayed into the console where the "GREEN" highlighted text represents slang or lingo expansions where as "WHITE" highlighted text represents replacement from dictionary for improved data mining detection. The 
"UN HIGHLIGHTED" text represents texts that couldn't be found in either dictionaries and might be typos etc

