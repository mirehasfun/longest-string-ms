package com.github.mirehasfun.lsms.domain;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Component that implements the business logic of finding and extracting the desired elements of a given input array.
 * <p>
 * That is, it finds the longest strings in an array of strings, that start with the latest character of the alphabet
 * contained in the string of the first element.
 * <p>
 * Example:
 * <pre>
 *     input = ["abc", "def", "cars", "coma", "cabbage", "curious", "drainpipe"]
 *     result = ["cabbage", "curious"]
 * </pre>
 */
@Component
public class StringExtractor {

    /**
     * Finds all longest strings of the given input array that start with the latest (alphabetically) character of the
     * first element of the array.
     *
     * @param inputArray Array containing strings
     * @return An array containing the found strings. If the parameter is {@code null}, an empty array is returned.
     */
    public String[] findAllLongestStringsStartingWith(String[] inputArray) {
        if (inputArray == null) {
            return new String[]{};
        }

        return findAllLongestStringsWithStartCharacter(extractStartingCharacter(inputArray[0]), inputArray);
    }

    //Analyzes the given string and extracts the one character, that is alphabetically speaking the last one.
    private String extractStartingCharacter(String firstElement) {
        return Stream.of(firstElement.split(""))
                .max(String::compareTo)
                .get();
    }

    //Extracts the longest strings in haystack, that start with the startingCharacter
    private String[] findAllLongestStringsWithStartCharacter(String startingCharacter, String[] haystack) {
        //Group Strings that start with the starting character in a Map with key=length and value=list of strings
        Map<Integer, List<String>> groupedByStringLength = Stream.of(haystack)
                .filter(elem -> elem.startsWith(startingCharacter))
                .collect(Collectors.groupingBy(String::length));

        //Find the map entry representing the list with the longest strings and add all the values into the return list
        List<String> returnList = new LinkedList<>();
        groupedByStringLength.keySet().stream()
                .max(Integer::compareTo)
                .ifPresent(maxLength -> returnList.addAll(groupedByStringLength.get(maxLength)));

        return returnList.toArray(new String[]{});
    }
}
