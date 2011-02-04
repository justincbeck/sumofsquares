package com.beckproduct.sos.job;

import junit.framework.TestCase;

import org.tiling.computefarm.JobRunner;
import org.tiling.computefarm.JobRunnerFactory;
import org.tiling.computefarm.impl.simple.SimpleJobRunnerFactory;

public class SquaresJobTest extends TestCase
{
    public void test()
    {
        double d = 10;
        SquaresJob job = new SquaresJob(d);
        JobRunnerFactory factory = new SimpleJobRunnerFactory();
        JobRunner jobRunner = factory.newJobRunner(job);
        jobRunner.run();
        assertEquals(d * (d + 1) * (2 * d + 1) / 6, job.getSumOfSquares(), 0);
    }
}
