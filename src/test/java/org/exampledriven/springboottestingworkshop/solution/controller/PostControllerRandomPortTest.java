package org.exampledriven.springboottestingworkshop.solution.controller;

import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Peter Szanto on 7/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerRandomPortTest {
    private static final String JOHN = "John";
    private static final String DOE = "Doe";
    private static final int USER_ID = 1;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void readPost() {

        PersonAndPost personAndPost = testRestTemplate.getForObject("/post?firstName={firstName}&lastName={lastName}", PersonAndPost.class, JOHN, DOE);

        assertEquals(JOHN, personAndPost.getPerson().getFirstName());
        assertEquals(DOE, personAndPost.getPerson().getLastName());
        assertEquals(USER_ID, personAndPost.getPerson().getId());

        assertEquals(10, personAndPost.getPosts().size());

        Post firstPost = personAndPost.getPosts().get(0);
        assertEquals(1, firstPost.getId());
        assertEquals(USER_ID, firstPost.getUserId());
        assertTrue(firstPost.getTitle() != null);
        assertTrue(firstPost.getBody() != null);

    }

}