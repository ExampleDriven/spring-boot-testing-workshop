package org.exampledriven.springboottestingworkshop.performance.runner;

import org.junit.runner.notification.RunNotifier;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class MockitoJUnitRunnerMeasurer extends MockitoJUnitRunner {

    private Date start;

    public MockitoJUnitRunnerMeasurer(Class<?> klass) throws InvocationTargetException {

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
