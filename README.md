# Count Words Coding Assignment
created an indexing process for a search system.  It will process a file and apply the following business rules:
- Counts and returns the NUMBER of words (i.e. Strings) that start with "M" or "m"
- Returns all the words longer than 5 characters

##  Technologies Used
- Java 24
- JUnit 5

## Clone the Repository
   
   git clone  https://github.com/symanware/CountWordsAssignment.git
    
   Build the Project
   
   With Maven: mvn clean install package

   Run test cases
   
   With Maven: mvn test

   Run the Application
   
   java -jar CountWordsAssignment-1.0-SNAPSHOT.jar [provide .txt input file for indexing]
   eg. java -jar CountWordsAssignment-1.0-SNAPSHOT.jar doc.txt


## Sample output

This output displaying occurences of words with file line numbers

$ java -jar CountWordsAssignment-1.0-SNAPSHOT.jar doc.txt

Number of words starting with 'M' or 'm': 9

monkeys => lines: [1]

mountains => lines: [1]

move => lines: [1]

mysterious => lines: [1]

Meanwhile => lines: [2]

man => lines: [1, 1]

Many => lines: [1]

mist => lines: [1]

-----------------------------------------------------------------------------------------
Words longer than 5 characters:

monkeys => lines: [1]

mountains => lines: [1]

mysterious => lines: [1]

Meanwhile => lines: [2]

others => lines: [2]

quietly => lines: [2]






