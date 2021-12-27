package com.credits.dojo.unit.tests.samples;

import com.credits.dojo.unit.tests.utils.Counter;

/**
 * Simple step counter.
 */
public class FitnessTracker {

    public static final int RUN_STEPS_FACTOR = 2;

    /**
     * Registers one normal step.
     */
    public void step() {
        Counter.getInstance().add();
    }

    /**
     * Registers one run step, which is equivalent to two normal steps.
     */
    public void runStep() {
        Counter.getInstance().add(RUN_STEPS_FACTOR);
    }

    /**
     * Gets the total amount of steps registered.
     * @return Total amount of steps.
     */
    public int getTotalSteps() {
        return Counter.getInstance().getTotalCount();
    }
}
