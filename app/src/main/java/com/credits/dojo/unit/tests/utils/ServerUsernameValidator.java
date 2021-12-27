package com.credits.dojo.unit.tests.utils;

import androidx.annotation.NonNull;

public class ServerUsernameValidator {

    /**
     * The sleep instruction mimics a network request that checks whether the username is free but
     * ultimately fails due to the absence of network connection.
     * @param username The user name to be validated, it cannot be null.
     * @return <b>true</b> if the username is valid, <b>false</b> otherwise.
     */
    public static boolean isValidUsername(@NonNull String username) {
        try {
            Thread.sleep(1000);
            throw new RuntimeException("No network connection");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
