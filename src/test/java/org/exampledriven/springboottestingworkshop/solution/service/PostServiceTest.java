package org.exampledriven.springboottestingworkshop.solution.service;

import org.exampledriven.springboottestingworkshop.domain.Person;
import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void readPersonAndPost() throws Exception {
        Person expectedPerson = new Person();
        expectedPerson.setFirstName("John");
        expectedPerson.setLastName("Doe");

        PersonAndPost actual = postService.readPersonAndPost(expectedPerson.getFirstName(), expectedPerson.getLastName());

        assertEquals(expectedPerson.getFirstName(), actual.getPerson().getFirstName());
        assertEquals(expectedPerson.getLastName(), actual.getPerson().getLastName());

        assertEquals(10, actual.getPosts().size());
    }

}