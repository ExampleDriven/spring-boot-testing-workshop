package org.exampledriven.springboottestingworkshop.controller;

import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Peter Szanto on 7/4/2017.
 */

public class PostControllerRandomPortTest {
    private static final String JOHN = "John";
    private static final String DOE = "Doe";
    private static final int USER_ID = 1;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void readPost() throws Exception {
        //TODO 9 implement this test using webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT

    }

}