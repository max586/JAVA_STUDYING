package mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class StoreTest {

    public static final long ANY_POSITIVE_LONG = 1L;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock SellerLegacy seller;
    @Mock Item item;

    @InjectMocks Store store;

    @Before
    public void setUp(){
        given(item.id()).willReturn(ANY_POSITIVE_LONG);
    }

    @Test
    public void shouldReturnItemIfInStore() {
        store.addItem(item);
        assertThat(store.getItem(ANY_POSITIVE_LONG)).contains(item);
    }

    @Test
    public void shouldNotReturnItemIfNotInStore() {
        assertThat(store.getItem(ANY_POSITIVE_LONG)).isEmpty();
    }

    @Test
    public void shouldReturnAllAddedItems() {
        var item2 = mock(Item.class);
        given(item2.id()).willReturn(ANY_POSITIVE_LONG+1);

        store.addItem(item).addItem(item2);

        assertThat(store.getItems()).containsOnly(item,item2);
    }

    @Test
    public void shouldSellItemIfInStore() {
        var client = mock(ClientLegacy.class);
        store.addItem(item);

        store.sellItem(ANY_POSITIVE_LONG,client);

        //should sell this specific item to this specific client
        then(seller).should().sellItem(item, client);
        //should sell any item to similar client to this one
        then(seller).should().sellItem(any(), eq(client));
        //should sell any item to any client
        then(seller).should().sellItem(any(), any());
    }
}