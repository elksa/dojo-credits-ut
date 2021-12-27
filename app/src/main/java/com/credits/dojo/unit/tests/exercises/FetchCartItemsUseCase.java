package com.credits.dojo.unit.tests.exercises;

import androidx.annotation.NonNull;

import com.credits.dojo.unit.tests.exercises.GetCartItemsHttpEndpoint.FailReason;

import java.util.ArrayList;
import java.util.List;

public class FetchCartItemsUseCase {

    public interface Listener {

        void onCartItemsFetched(List<CartItemEntity> items);

        void onError(FailReason failReason);
    }

    private final List<Listener> listeners = new ArrayList<>();
    private final GetCartItemsHttpEndpoint getCartItemsHttpEndpoint;

    public FetchCartItemsUseCase(GetCartItemsHttpEndpoint getCartItemsHttpEndpoint) {
        this.getCartItemsHttpEndpoint = getCartItemsHttpEndpoint;
    }

    public void fetchCartItems(int limit) {
        getCartItemsHttpEndpoint.getCartItems(limit, new GetCartItemsHttpEndpoint.Callback() {
            @Override
            public void onGetCartItemsSucceeded(List<CartItemDto> cartItems) {
                for (Listener listener : listeners) {
                    listener.onCartItemsFetched(getCartItemsFromDto(cartItems));
                }
            }

            @Override
            public void onGetCartItemsFailed(FailReason failReason) {
                for (Listener listener : listeners) {
                    listener.onError(failReason);
                }
            }
        });
    }

    public void registerListener(@NonNull Listener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(@NonNull Listener listener) {
        listeners.remove(listener);
    }

    @NonNull
    private List<CartItemEntity> getCartItemsFromDto(@NonNull List<CartItemDto> cartItems) {

        List<CartItemEntity> result = new ArrayList<>();

        for (CartItemDto cartItem : cartItems) {
            result.add(
                    new CartItemEntity(
                            cartItem.getId(),
                            cartItem.getTitle(),
                            cartItem.getDescription(),
                            cartItem.getPrice()
                    )
            );
        }

        return result;
    }
}
