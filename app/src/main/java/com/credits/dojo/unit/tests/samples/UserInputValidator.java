package com.credits.dojo.unit.tests.samples;

import androidx.annotation.NonNull;

import com.credits.dojo.unit.tests.utils.ServerUsernameValidator;

/**
 * Validates user input, consisting in the full name and the username.
 */
public class UserInputValidator {

    /**
     * Validates a given full name, which will be valid if it is not an empty String.
     * @param fullName to be validated.
     * @return <b>true</b> if the full name is valid, <b>false</b> otherwise.
     */
    public boolean isFullNameValid(@NonNull String fullName) {
        return !fullName.isEmpty();
    }

    /**
     * Validates a given user name, which will be valid if it is not an empty String.
     * @param username to be validated.
     * @return <b>true</b> if the user name is valid, <b>false</b> otherwise.
     */
    public boolean isUsernameValid(@NonNull String username) {
        return ServerUsernameValidator.isValidUsername(username);
    }
}
