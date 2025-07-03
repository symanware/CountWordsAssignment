package org.example;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleFilterEngine {
    private List<BusinessRuleFilter> rules = new ArrayList<>();

    public void addRule(BusinessRuleFilter rule) {
        rules.add(rule);
    }

    public List<BusinessRuleFilter> getRules() {
        return rules;
    }
}
