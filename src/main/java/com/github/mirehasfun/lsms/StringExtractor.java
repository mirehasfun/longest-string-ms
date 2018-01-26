package com.github.mirehasfun.lsms;

import java.util.Comparator;
import java.util.stream.Stream;

public class StringExtractor {

    public String[] findAllLongestStringsStartingWith(String[] inputArray) {
        if (inputArray == null || inputArray.length <= 1) {
            throw new IllegalArgumentException("inputArray must be non-null and have a size > 1");
        }

        return new String[]{};
    }

    //Analyzes the given string and extracts the one character, that is alpabetically speaking the last one.
    String extractStartingCharacter(String firstElement) {
        return Stream.of(firstElement.split(""))
                .min(Comparator.reverseOrder())
                .get();
    }
}
