package com.credits.dojo.unit.tests.utils;

public class Counter {

    private static Counter instance;

    private int totalCount;

    public static Counter getInstance() {
        return instance == null ? instance = new Counter() : instance;
    }

    private Counter() {
        totalCount = 0;
    }

    public void add() {
        totalCount++;
    }

    public void add(int count) {
        totalCount += count;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
