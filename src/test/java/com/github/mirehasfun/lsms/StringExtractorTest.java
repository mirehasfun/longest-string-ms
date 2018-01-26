package com.github.mirehasfun.lsms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String[] expected = new String[]{"bcd", "bab"}; //FIXME: the order is not as in the source Array. Research on Array Matchers
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

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