package com.credits.dojo.unit.tests.exercises;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import androidx.annotation.NonNull;
import com.credits.dojo.unit.tests.exercises.GetCartItemsHttpEndpoint.Callback;
import com.credits.dojo.unit.tests.exercises.GetCartItemsHttpEndpoint.FailReason;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FetchCartItemsUseCaseTest {

    // region Constants
    private final int LIMIT = 20;
    // endregion

    // region Helper fields

    @Mock
    private GetCartItemsHttpEndpoint getCartItemsHttpEndpointMock;

    @Mock
    private FetchCartItemsUseCase.Listener listener1Mock;

    @Mock
    private FetchCartItemsUseCase.Listener listener2Mock;

    @Captor
    private ArgumentCaptor<List<CartItemEntity>> cartItemsCaptor;

    private List<CartItemDto> cartItemsDto;

    // endregion

    private FetchCartItemsUseCase sut;

    @Before
    public void setUp() {
        sut = new FetchCartItemsUseCase(getCartItemsHttpEndpointMock);
        cartItemsDto = getCartItemsDto();
    }

    // region Helper methods

    private void setUpSuccess() {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Callback callback = (Callback) args[1];
            callback.onGetCartItemsSucceeded(getCartItemsDto());
            return null;
        }).when(getCartItemsHttpEndpointMock).getCartItems(anyInt(), any(Callback.class));
    }

    private void setUpError(FailReason failReason) {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Callback callback = (Callback) args[1];
            callback.onGetCartItemsFailed(failReason);
            return null;
        }).when(getCartItemsHttpEndpointMock).getCartItems(anyInt(), any(Callback.class));
    }

    @NonNull
    private List<CartItemEntity> getCartItemsFromDto(@NonNull List<CartItemDto> cartItems) {
        List<CartItemEntity> items = new ArrayList<>();
        for (CartItemDto cartItem : cartItems) {
            items.add(new CartItemEntity(
                    cartItem.getId(),
                    cartItem.getTitle(),
                    cartItem.getDescription(),
                    cartItem.getPrice()
            ));
        }
        return items;
    }

    @NonNull
    private List<CartItemDto> getCartItemsDto() {
        List<CartItemDto> items = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            items.add(new CartItemDto(i, "TITLE", "DESCRIPTION", 5));
        }
        return items;
    }

    // endregion
}