package org.exampledriven.springboottestingworkshop.solution.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Peter Szanto on 7/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PostControllerMockTest {
    private static final String JOHN = "John";
    private static final String DOE = "Doe";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void readPost() throws Exception {

        ResultActions resultActions = mockMvc.perform(
                get("/post")
                        .param("firstName", JOHN)
                        .param("lastName", DOE)
        );

        resultActions
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        resultActions
            .andExpect(jsonPath("$.person.id", is(1)))
            .andExpect(jsonPath("$.person.lastName", is(DOE)))
            .andExpect(jsonPath("$.person.firstName", is(JOHN)));

        resultActions
            .andExpect(jsonPath("$.posts", hasSize(10)))
            .andExpect(jsonPath("$.posts[0].userId", is(1)))
            .andExpect(jsonPath("$.posts[0].title", any(String.class)))
            .andExpect(jsonPath("$.posts[0].body", any(String.class)));

    }

}