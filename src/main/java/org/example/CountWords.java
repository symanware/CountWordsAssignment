package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Program that executes indexing process and applies different business rule
public class CountWords {


        private BusinessRuleFilterEngine filterEngine = new BusinessRuleFilterEngine();private int startsWithGivenCharCount = 0;
        private Map<String,List<Integer>> startsWithGivenChar =  new HashMap<>();
        private Map<String,List<Integer>> longerThanGivenLengthWords = new HashMap<>();

        //Accepting input file from commnad line to process indexing
        public static void main(String[] args) {
            CountWords countWords = new CountWords();

            countWords.loadRules("config.properties");
            countWords.processFile(args[0]);
            countWords.displayResults();

        }

    //Load config file for business rules and rules in filterEngine for further processing
    private void loadRules(String configFile) {

        try {

            Properties prop = new Properties();
            prop.load(CountWords.class.getClassLoader().getResourceAsStream(configFile));

            int minLength = Integer.parseInt(prop.getProperty("minLength"));
            char startsWithLetter = prop.getProperty("startsWithLetter").toLowerCase().charAt(0);

            filterEngine.addRule(new StartsWithCharRule(startsWithLetter));
            filterEngine.addRule(new WordLengthRule(minLength));

        } catch (IOException e) {
            System.err.println("Error loading config: " + e.getMessage());
        }

    }

    //Indexing and applying business rules on file
    private void processFile(String filePath) {

        try (BufferedReader br
                     = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {

                lineNumber++;
                String[] words = line.split("\\W+");

                for (String word : words) {
                    String lower = word.toLowerCase();

                    for (BusinessRuleFilter rule : filterEngine.getRules()) {
                        if (rule instanceof StartsWithCharRule && rule.apply(lower)) {

                            startsWithGivenCharCount++;
                            startsWithGivenChar.computeIfAbsent(word, k -> new ArrayList<>()).add(lineNumber);
                        }
                        if (rule instanceof WordLengthRule && rule.apply(lower)) {

                            longerThanGivenLengthWords.computeIfAbsent(word, k -> new ArrayList<>()).add(lineNumber);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    //Displaying final results after indexing and applying all business rules
    private void displayResults() {
        System.out.println("\n");
        System.out.println("Number of words starting with 'M' or 'm': " + startsWithGivenCharCount);
        System.out.println("\n");
        for (Map.Entry<String, List<Integer>> entry : startsWithGivenChar.entrySet()) {
            System.out.println(entry.getKey() + " => lines: " + entry.getValue() + "\n");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Words longer than 5 characters:");
        System.out.println("\n");
        for (Map.Entry<String, List<Integer>> entry : longerThanGivenLengthWords.entrySet()) {
            System.out.println(entry.getKey() + " => lines: " + entry.getValue() + "\n");
        }
    }

}