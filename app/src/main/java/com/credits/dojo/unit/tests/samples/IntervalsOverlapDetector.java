package com.credits.dojo.unit.tests.samples;

import androidx.annotation.NonNull;

import com.credits.dojo.unit.tests.utils.Interval;

public class IntervalsOverlapDetector {

    public boolean isOverlapping(@NonNull Interval intervalStart, @NonNull Interval intervalEnd) {
        return intervalStart.getEnd() > intervalEnd.getStart()
                && intervalStart.getStart() <= intervalEnd.getEnd();
    }
}
