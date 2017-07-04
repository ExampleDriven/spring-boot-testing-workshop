package org.exampledriven.springboottestingworkshop.solution.service;

import org.exampledriven.springboottestingworkshop.service.BlackBoxService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlackBoxServiceTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Autowired
    private BlackBoxService blackBoxService;

    @Test
    public void doUntestableThings() {
        blackBoxService.doUntestableThings();
        assertThat(capture.toString()).contains("Secret processing is done");
    }

}