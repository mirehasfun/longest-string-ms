package com.github.mirehasfun.lsms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LongestStringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostallLongestStringsStartingWith() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/allLongestStringsStartingWith")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"inputArray\": [\"abc\", \"def\"]}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": [\"Hello\", \"World\", \"abc\", \"def\"]}"));
    }
}
