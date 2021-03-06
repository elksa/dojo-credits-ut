package com.credits.dojo.unit.tests.utils;

public class Interval {

    private final int start;
    private final int end;

    public Interval(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Invalid interval range");
        }

        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
