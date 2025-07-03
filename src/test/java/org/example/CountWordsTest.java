package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountWordsTest {

    @Test
    public void testStartsWithCharRule() {
        StartsWithCharRule rule = new StartsWithCharRule('m');

        assertTrue(rule.apply("Mountain"));
        assertTrue(rule.apply("monkey"));
        assertFalse(rule.apply("apple"));
        assertFalse(rule.apply(""));
    }

    @Test
    public void testWordLengthRule() {
        WordLengthRule  rule = new WordLengthRule(6);

        assertTrue(rule.apply("python"));
        assertTrue(rule.apply("Mountain"));
        assertFalse(rule.apply("apple"));    // 5 characters
        assertFalse(rule.apply("go"));
        assertFalse(rule.apply(""));
    }

    @Test
    public void testBusinessRuleFilterEngine_combinedRules() {
        BusinessRuleFilterEngine engine = new BusinessRuleFilterEngine();
        engine.addRule(new StartsWithCharRule('m'));
        engine.addRule(new WordLengthRule(6));

        assertTrue(engine.getRules().getFirst().apply("mountain"));
        assertFalse(engine.getRules().getLast().apply("monk"));
        assertFalse(engine.getRules().getFirst().apply("apples"));
    }
}
