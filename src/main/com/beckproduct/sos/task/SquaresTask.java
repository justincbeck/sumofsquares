package com.beckproduct.sos.task;

import java.io.Serializable;

import org.tiling.computefarm.Task;

public class SquaresTask implements Serializable, Task
{
    private final static long serialVersionUID = 1L;

    private final double k;

    public SquaresTask(double k)
    {
        this.k = k;
    }

    public Object execute()
    {
        return k * k;
    }
}
