package org.exampledriven.springboottestingworkshop.solution.service;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.Person;
import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.exampledriven.springboottestingworkshop.repository.PersonRepository;
import org.exampledriven.springboottestingworkshop.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PostServiceMockTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostClient postClient;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void readPersonAndPost() {

        // setup postClient
        Person expectedPerson = new Person();
        expectedPerson.setFirstName("Ada");
        expectedPerson.setLastName("Lovelace");
        expectedPerson.setId(1);

        List<Post> expectedPosts = new LinkedList<>();
        Post post = new Post();
        post.setId(6);
        expectedPosts.add(post);

        given(postClient.readPosts(1)).willReturn(expectedPosts);

        // setup personRepository
        given(personRepository.findByFirstNameAndLastName(expectedPerson.getFirstName(), expectedPerson.getLastName())).willReturn(expectedPerson);


        // perform
        PersonAndPost actual = postService.readPersonAndPost(expectedPerson.getFirstName(), expectedPerson.getLastName());

        assertEquals(expectedPerson.getFirstName(), actual.getPerson().getFirstName());
        assertEquals(expectedPerson.getLastName(), actual.getPerson().getLastName());

        assertEquals(1, actual.getPosts().size());

        verify(postClient).readPosts(1);
        verify(personRepository).findByFirstNameAndLastName(expectedPerson.getFirstName(), expectedPerson.getLastName());

    }

}