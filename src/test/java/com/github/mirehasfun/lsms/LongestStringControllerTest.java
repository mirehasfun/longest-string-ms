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
    public void testAllLongestStringsStartingWith_Example1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/allLongestStringsStartingWith")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"inputArray\": [\"abba\", \"bab\", \"ad\", \"bcd\", \"aba\"]}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": [\"bab\", \"bcd\"]}"));
    }

    @Test
    public void testAllLongestStringsStartingWith_Example2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/allLongestStringsStartingWith")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"inputArray\": [\"zorro\", \"zorba\", \"zuzan\", \"zoo\", \"zeus\", \"alemania\"]}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": [\"zorro\", \"zorba\", \"zuzan\"]}"));
    }

    @Test
    public void testAllLongestStringsStartingWith_Example3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/allLongestStringsStartingWith")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"inputArray\": [\"zorg\", \"zum\", \"zu\", \"zoo\", \"zeus\", \"alemania\"]}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": [\"zorg\", \"zeus\"]}"));
    }
}
