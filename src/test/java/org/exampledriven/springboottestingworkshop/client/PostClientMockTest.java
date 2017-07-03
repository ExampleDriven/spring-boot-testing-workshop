package org.exampledriven.springboottestingworkshop.client;


import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.Post;
import org.exampledriven.springboottestingworkshop.solution.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by Peter Szanto on 7/2/2017.
 */
@RunWith(SpringRunner.class)
@RestClientTest(PostClient.class)
public class PostClientMockTest {

    @Autowired
    private PostClient postClient;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Value("posts.json")
    private Resource postsJson;

    @Test
    public void readPosts() throws Exception {

        String mockJsonResponse = TestUtil.toString(postsJson.getInputStream());

        //TODO 2

    }

}