package org.exampledriven.springboottestingworkshop.solution.performance;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.repository.PersonRepository;
import org.exampledriven.springboottestingworkshop.service.PostService;
import org.exampledriven.springboottestingworkshop.performance.runner.SpringRunnerMeasurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunnerMeasurer.class)
@SpringBootTest(classes = {ConfigInnerContextTest.Config.class, PostService.class})
public class ConfigInnerContextTest {

    @MockBean
    private PersonRepository personRepositoryMock;

    @MockBean
    private PostClient postClientMock;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PostService postService;

    @Test
    public void testBeans() {

        assertNotNull(postService);
        assertEquals(14, context.getBeanDefinitionCount());

    }

    //nested @Configuration replaces the application’s primary configuration
    @Configuration
    static class Config {

    }

}