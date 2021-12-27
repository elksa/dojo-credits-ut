package com.credits.dojo.unit.tests.samples;

import org.junit.Before;

public class IntervalsOverlapDetectorTest {

    private IntervalsOverlapDetector sut;

    @Before
    public void setUp() {
        sut = new IntervalsOverlapDetector();
    }

    // interval 1 is before interval 2 -> false

    // interval 1 overlaps interval 2 at start -> true

    // interval 1 is contained withing interval 2 -> true

    // interval 1 contains interval 2 -> true

    // interval 1 overlaps interval 2 at the end -> true

    // interval 1 is after interval 2 -> true

    // interval 1 is before and adjacent to interval 2 -> false

}