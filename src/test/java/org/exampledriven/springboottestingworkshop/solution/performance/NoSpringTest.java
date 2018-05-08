package org.exampledriven.springboottestingworkshop.solution.performance;

import org.exampledriven.springboottestingworkshop.client.PostClient;
import org.exampledriven.springboottestingworkshop.repository.PersonRepository;
import org.exampledriven.springboottestingworkshop.service.PostService;
import org.exampledriven.springboottestingworkshop.performance.runner.MockitoJUnitRunnerMeasurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Peter Szanto on 7/3/2017.
 */
@RunWith(MockitoJUnitRunnerMeasurer.class)
public class NoSpringTest {

    @Mock
    private PersonRepository personRepositoryMock;

    @Mock
    private PostClient postClientMock;

    @InjectMocks
    private PostService postService;

    @Test
    public void testBeans() {
        assertNotNull(postService);
    }

}

