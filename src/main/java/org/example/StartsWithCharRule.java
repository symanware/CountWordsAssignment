package org.example;

//Business rule class to filter words starting with given character
public class StartsWithCharRule implements BusinessRuleFilter {
    private char letter;

    public StartsWithCharRule(char letter) {

        this.letter = Character.toLowerCase(letter);
    }

    public boolean apply(String word) {

        return !word.isEmpty() && Character.toLowerCase(word.charAt(0)) == letter;
    }

}
