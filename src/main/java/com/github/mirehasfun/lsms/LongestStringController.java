package com.github.mirehasfun.lsms;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing the REST controller for the "LongestString" microservice.
 */
@RestController
public class LongestStringController {

    /**
     * The RequestMapping exposing the "allLongestStringsStartingWith" endpoint.
     *
     * @param request A {@link LongestStringRequest} request object containing the POST payload.
     * @return A {@link LongestStringResponse} containing the result of the business operation.
     */
    @RequestMapping(value = "/allLongestStringsStartingWith", method = RequestMethod.POST)
    public LongestStringResponse allLongestStringsStartingWith(@RequestBody LongestStringRequest request) {
        List<String> resultList = new LinkedList<>(Arrays.asList("Hello", "World"));
        resultList.addAll(Arrays.asList(request.getInputArray()));

        LongestStringResponse response = new LongestStringResponse();
        response.setResult(resultList.toArray(new String[]{}));
        return response;
    }
}
