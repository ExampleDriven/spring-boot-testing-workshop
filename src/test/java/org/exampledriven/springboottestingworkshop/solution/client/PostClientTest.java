package org.exampledriven.springboottestingworkshop.solution.client;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Peter Szanto on 7/2/2017.
 */
@RunWith(SpringRunner.class)
@RestClientTest(PostClient.class)
@AutoConfigureMockRestServiceServer(enabled = false)
public class PostClientTest {

    @Autowired
    private PostClient postClient;

    @Test
    public void readPosts() {
        List<Post> posts = postClient.readPosts(1);
        assertEquals(10, posts.size());
    }

}