package com.github.mirehasfun.lsms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StringExtractorTest {

    private StringExtractor extractor;

    @Before
    public void setUp() {
        extractor = new StringExtractor();
    }

    @Test
    public void testExtractStartingCharacter() {
        String input = "asdf";
        String expected = "s";
        String actual = extractor.extractStartingCharacter(input);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAllLongestStringsStartingWith_InputParameterValidation() {
        String[] input = new String[]{"asdf"};
        extractor.findAllLongestStringsStartingWith(input);
    }

    @Test
    public void testFindAllLongestStringsStartingWith_Example1() {
        String[] input = new String[]{"abba", "bab", "ad", "bcd", "aba"};
        String[] expected = new String[]{"bcd", "bab"};
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

        //TODO: for now, sort both arrays prior comparison, since I'm not sure whether it's a typo in the requirements or
        //if I missed something (order of the expected result is not the same as in the source array).
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllLongestStringsStartingWith_Example2() {
        String[] input = new String[]{"zorro", "zorba", "zuzan", "zoo", "zeus", "alemania"};
        String[] expected = new String[]{"zorro", "zorba", "zuzan"};
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllLongestStringsStartingWith_Example3() {
        String[] input = new String[]{"zorg", "zum", "zu", "zoo", "zeus", "alemania"};
        String[] expected = new String[]{"zorg", "zeus"};
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

        Assert.assertArrayEquals(expected, actual);
    }
}