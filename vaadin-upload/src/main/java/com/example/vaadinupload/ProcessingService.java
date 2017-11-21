package com.example.vaadinupload;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author Alejandro Duarte
 */
@Service
public class ProcessingService {

    /**
     * This method simulates a processing job
     **/
    @Async // run in a separate thread
    public void processData(String data,
                            Consumer<Float> progressListener,
                            Runnable succeededListener) {

        final int STEPS = 20;
        for (int i = 1; i <= STEPS; i++) {
            sleep();
            int totalCharCount = data.length();
            int processedCharCount = totalCharCount / STEPS * i;
            float processedPercentage = (float) processedCharCount / totalCharCount;
            progressListener.accept(processedPercentage); // notify progress listener
        }

        succeededListener.run(); // notify succeeded listener
    }

    private void sleep() {
        try {
            int lower = 500;
            int upper = 3000;
            Thread.sleep((long) ((Math.random() * (upper - lower)) + lower));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
