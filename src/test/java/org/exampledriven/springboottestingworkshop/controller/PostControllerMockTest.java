package org.exampledriven.springboottestingworkshop.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
public class PostControllerMockTest {

    private static final String JOHN = "John";
    private static final String DOE = "Doe";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void readPost() throws Exception {
        //TODO 8 implement this test using webEnvironment = SpringBootTest.WebEnvironment.MOCK
    }

}