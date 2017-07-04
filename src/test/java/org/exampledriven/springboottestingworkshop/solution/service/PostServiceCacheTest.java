package org.exampledriven.springboottestingworkshop.solution.service;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.domain.PersonAndPost;
import org.exampledriven.springboottestingworkshop.service.PostService;
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

    @SpyBean
    private PostClient postClient;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void evictAllCaches() {
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }

    @Test
    public void readPersonAndPost() {

        PersonAndPost personFromDB = postService.readPersonAndPost(JOHN, DOE);

        assertEquals(JOHN, personFromDB.getPerson().getFirstName());
        assertEquals(DOE, personFromDB.getPerson().getLastName());

        assertEquals(10, personFromDB.getPosts().size());

        PersonAndPost personCached = postService.readPersonAndPost(JOHN, DOE);

        assertEquals(JOHN, personCached.getPerson().getFirstName());
        assertEquals(DOE, personCached.getPerson().getLastName());

        verify(postClient, times(1)).readPosts(1);

    }

}