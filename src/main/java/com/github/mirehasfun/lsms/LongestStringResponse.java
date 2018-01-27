package com.github.mirehasfun.lsms;

/**
 * Class representing a response object from the "allLongestStringsStartingWith" endpoint
 * ({@link LongestStringController#allLongestStringsStartingWith(LongestStringRequest)}
 */
public class LongestStringResponse {

    private String[] result;

    public String[] getResult() {
        return result;
    }

    public void setResult(String[] result) {
        this.result = result;
    }
}
