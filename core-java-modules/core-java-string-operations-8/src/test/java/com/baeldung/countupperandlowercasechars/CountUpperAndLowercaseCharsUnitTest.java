package com.baeldung.countupperandlowercasechars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountUpperAndLowercaseCharsUnitTest {
    private static final String MY_STRING = "Hi, Welcome to Baeldung! Let's count letters!";

    @Test
    void whenIteratingCharArrayCompareAndCount_thenGetExpectedResult() {
        int upperCnt = 0;
        int lowerCnt = 0;
        for (char c : MY_STRING.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                upperCnt++;
            }
            if (c >= 'a' && c <= 'z') {
                lowerCnt++;
            }
        }
        LetterCount result = new LetterCount(upperCnt, lowerCnt);
        assertEquals(4, result.getUppercaseCount());
        assertEquals(31, result.getLowercaseCount());
    }

    @Test
    void whenUsingCharacterIsLowerOrUpperCase_thenGetExpectedResult() {
        int upperCnt = 0;
        int lowerCnt = 0;
        for (char c : MY_STRING.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCnt++;
            }
            if (Character.isLowerCase(c)) {
                lowerCnt++;
            }
        }
        LetterCount result = new LetterCount(upperCnt, lowerCnt);
        assertEquals(4, result.getUppercaseCount());
        assertEquals(31, result.getLowercaseCount());
    }

    @Test
    void whenUsingStreamFilterAndCount_thenGetExpectedResult() {
        LetterCount result = new LetterCount(
            (int) MY_STRING.chars().filter(Character::isUpperCase).count(),
            (int) MY_STRING.chars().filter(Character::isLowerCase).count()
        );
        assertEquals(4, result.getUppercaseCount());
        assertEquals(31, result.getLowercaseCount());
    }
}

class LetterCount {
    private int uppercaseCount;
    private int lowercaseCount;

    public LetterCount(int uppercaseCount, int lowercaseCount) {
        this.uppercaseCount = uppercaseCount;
        this.lowercaseCount = lowercaseCount;
    }

    public int getUppercaseCount() {
        return uppercaseCount;
    }

    public int getLowercaseCount() {
        return lowercaseCount;
    }
}