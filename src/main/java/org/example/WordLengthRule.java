package org.example;

//Business rule class to filter words with given length
public class WordLengthRule implements BusinessRuleFilter {

    private int minLength;

    public WordLengthRule(int minLength) {

        this.minLength = minLength;
    }

    public boolean apply(String word) {

        return word.length() >= minLength;
    }
}
