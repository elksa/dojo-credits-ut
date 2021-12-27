package com.credits.dojo.unit.tests.exercises;

import java.util.List;

public interface GetCartItemsHttpEndpoint {

    enum FailReason {
        GENERAL_ERROR,
        NETWORK_ERROR
    }

    interface Callback {

        void onGetCartItemsSucceeded(List<CartItemDto> cartItems);

        void onGetCartItemsFailed(FailReason failReason);
    }

    /**
     * Gets cart items.
     * @param limit max amount of cart items to fetch.
     * @param callback object to be notified when the request completes.
     */
    void getCartItems(int limit, Callback callback);
}
