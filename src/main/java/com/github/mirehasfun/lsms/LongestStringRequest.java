package com.github.mirehasfun.lsms;

/**
 * Class representing a request object to the "allLongestStringsStartingWith" endpoint
 * ({@link LongestStringController#allLongestStringsStartingWith(LongestStringRequest)}
 */
public class LongestStringRequest {
    private String[] inputArray;

    public String[] getInputArray() {
        return inputArray;
    }

    public void setInputArray(String[] inputArray) {
        this.inputArray = inputArray;
    }
}
