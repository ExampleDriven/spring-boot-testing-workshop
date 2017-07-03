package org.exampledriven.springboottestingworkshop.service;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.Person;
import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.exampledriven.springboottestingworkshop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter Szanto on 7/3/2017.
 */
@Service
public class PostService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostClient postClient;

    public PersonAndPost readPersonAndPost(String firstName, String lastName) {

        Person person = personRepository.findByFirstNameAndLastName(firstName, lastName);

        if (person != null) {
            List<Post> posts = postClient.readPosts(person.getId());
            PersonAndPost personAndPost = new PersonAndPost();
            personAndPost.setPosts(posts);
            personAndPost.setPerson(person);

            return personAndPost;
        }

        return null;

    }
}
