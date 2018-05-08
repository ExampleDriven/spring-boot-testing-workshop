package org.exampledriven.springboottestingworkshop.performance.runner;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

public class SpringRunnerMeasurer extends SpringJUnit4ClassRunner {


    private Date start;

    public SpringRunnerMeasurer(Class<?> klass) throws InitializationError {

        super(klass);
        start = new Date();
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        long durationMillis = new Date().getTime() - start.getTime();
        System.out.println("\n-------\nDuration   - 00:" + (durationMillis / 1000) + ":" + (durationMillis % 1000) + "\n-------");
    }

}
