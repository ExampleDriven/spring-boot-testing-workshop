package org.exampledriven.springboottestingworkshop.service;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PostServiceCacheTest {

    private static final String JOHN = "John";
    private static final String DOE = "Doe";

    @Autowired
    private PostService postService;

    @Test
    public void readPersonAndPost() {

        PersonAndPost personFromDB = postService.readPersonAndPost(JOHN, DOE);

        //TODO 6 create a SpyBean of PostClient call PostService multiple time, verify PostClient

    }

}