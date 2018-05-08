package org.exampledriven.springboottestingworkshop.performance;

import org.exampledriven.springboottestingworkshop.service.PostService;
import org.exampledriven.springboottestingworkshop.performance.runner.SpringRunnerMeasurer;
import org.exampledriven.springboottestingworkshop.solution.performance.ConfigInnerContextTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunnerMeasurer.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@SpringBootTest(classes = {FullContextTest.Config.class, PostService.class})
public class FullContextTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PostService postService;

    @Test
    public void testBeans() {

        // TODO 11 try the three different webenvironment options, and limiting the scope by using a nested @Configuration
        // Make the nested configuration work by using @MockBean instances of missing classes

        assertNotNull(postService);
        System.out.println("\n-------\nNumber of beans created : " + context.getBeanDefinitionCount());

    }

    //nested @Configuration replaces the application’s primary configuration
    //@Configuration
    static class Config {

    }

}