package com.intalgent.sos.job;

import org.tiling.computefarm.CancelledException;
import org.tiling.computefarm.CannotTakeResultException;
import org.tiling.computefarm.CannotWriteTaskException;
import org.tiling.computefarm.ComputeSpace;
import org.tiling.computefarm.Job;

import com.intalgent.sos.task.SquaresTask;

public class SquaresJob implements Job
{
    private final double n;

    private double sum;

    public SquaresJob(double n)
    {
        this.n = n;
    }

    public void generateTasks(ComputeSpace space)
    {
        for (int i = 1; i <= n; i++) {
            try {
                space.write(new SquaresTask(i));
            } catch (CannotWriteTaskException e) {
                break;
            } catch (CancelledException e) {
                break;
            }
        }
    }

    public void collectResults(ComputeSpace space)
    {
        sum = 0;

        for (int i = 1; i <= n; i++) {
            try {
                Double result = (Double) space.take();
                sum += result.doubleValue();
            } catch (CannotTakeResultException e) {
                break;
            } catch (CancelledException e) {
                sum = 0;
                break;
            }
        }
    }

    public double getSumOfSquares()
    {
        return sum;
    }
}
