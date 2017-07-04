package org.exampledriven.springboottestingworkshop.controller;

import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public PersonAndPost readPost(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return postService.readPersonAndPost(firstName, lastName);
    }

}
