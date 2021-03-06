package com.github.mirehasfun.lsms.web;

import com.github.mirehasfun.lsms.domain.StringExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class representing the REST controller for the "LongestString" microservice.
 */
@RestController
public class LongestStringController {

    @Autowired
    private StringExtractor extractor;

    /**
     * The RequestMapping exposing the "allLongestStringsStartingWith" endpoint.
     *
     * @param request A {@link LongestStringRequest} request object containing the POST payload.
     * @return A {@link LongestStringResponse} containing the result of the business operation.
     */
    @RequestMapping(value = "/allLongestStringsStartingWith", method = RequestMethod.POST)
    public LongestStringResponse allLongestStringsStartingWith(@RequestBody LongestStringRequest request) {
        String[] result = extractor.findAllLongestStringsStartingWith(request.getInputArray());

        LongestStringResponse response = new LongestStringResponse();
        response.setResult(result);
        return response;
    }
}
