### Solution to word count problem
Given a text file on local file system, write a java program which counts unique words in the file. The file may contain multiple lines. 
The words in a line may be split by whitespace, comma or dot (“.”)

Program input params: 
1. path to the file.
2. integer number N which indicates the amount of words to output.

Expected output:

* “word – count”  pairs ordered by count in descending order.
* Exactly N pairs printed out if the amount of unique words is greater or equal to N; all pairs printed out otherwise.
* if there are more than one word with the same frequency, the words must be ordered alphabetically within corresponding group.


## Run
To build run gradlew or gradle.bat
````

gradlew clean build
cd build/libs
java -jar word_count.jar lyrics.txt 5

````


## Tests


````
gradlew test

````