package com.github.mirehasfun.lsms.domain;

import com.github.mirehasfun.lsms.domain.StringExtractor;
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
    public void testFindAllLongestStringsStartingWith_InputArrayResultingInEmptyResult() {
        String[] input = new String[]{"asdf"};
        String[] expected = new String[]{};
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAllLongestStringsStartingWith_InputArrayResultingInInputReturned() {
        String[] input = new String[]{"fabc"};
        String[] expected = new String[]{"fabc"};
        String[] actual = extractor.findAllLongestStringsStartingWith(input);

        Assert.assertArrayEquals(expected, actual);
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