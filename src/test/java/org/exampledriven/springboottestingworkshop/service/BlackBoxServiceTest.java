package org.exampledriven.springboottestingworkshop.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Peter Szanto on 7/4/2017.
 */
public class BlackBoxServiceTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Autowired
    private BlackBoxService blackBoxService;

    @Test
    public void doUntestableThings() {
        //TODO 10
    }

}