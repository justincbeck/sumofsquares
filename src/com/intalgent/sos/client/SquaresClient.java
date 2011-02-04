package com.intalgent.sos.client;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.tiling.computefarm.JobRunner;
import org.tiling.computefarm.JobRunnerFactory;
import org.tiling.computefarm.impl.javaspaces.util.ClasspathServer;

import com.intalgent.sos.job.SquaresJob;

public class SquaresClient
{
    private static Logger logger = Logger.getLogger(SquaresClient.class);
    
    public static void main(String[] args)
    {
		logger.info("Starting");
        BasicConfigurator.configure();
        
        if (args.length != 1) {
            logger.error("Usage: java " + SquaresClient.class.getName() + " <d>");
            System.exit(1);
        }

        ClasspathServer server = null;
        try {
            server = new ClasspathServer();
        } catch (IOException e) {
            logger.error("Error creating ClasspathServer...");
        }
        server.start();

		logger.info("Server started");

        double d = Double.parseDouble(args[0]);
        SquaresJob job = new SquaresJob(d);
        JobRunnerFactory factory = JobRunnerFactory.newInstance();
        JobRunner jobRunner = factory.newJobRunner(job);
        jobRunner.run();

        logger.info("d = " + d);
        logger.info("Sum of squares = " + job.getSumOfSquares());
        logger.info("d * (d + 1) * (2 * d + 1) / 6 = " + d * (d + 1) * (2 * d + 1) / 6);
    }
}
