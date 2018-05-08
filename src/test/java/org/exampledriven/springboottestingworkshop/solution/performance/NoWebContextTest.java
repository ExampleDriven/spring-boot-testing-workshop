package org.exampledriven.springboottestingworkshop.solution.performance;

import org.exampledriven.springboottestingworkshop.service.PostService;
import org.exampledriven.springboottestingworkshop.performance.runner.SpringRunnerMeasurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Peter Szanto on 7/3/2017.
 */

@RunWith(SpringRunnerMeasurer.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoWebContextTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PostService postService;

    @Test
    public void testBeans() {

        assertNotNull(postService);
        assertEquals(118, context.getBeanDefinitionCount());

    }

}