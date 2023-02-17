package power_mock.bad_code.seller;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import power_mock.bad_code.common.Price;
import power_mock.bad_code.item.Item;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


public class SellStaticsLegacyTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Item item;
    SellStaticsLegacy sellStaticsLegacy = new SellStaticsLegacy();

    @Test
    public void shouldAddItemPriceToSellStatistics() {
        var plnPrice = new Price(100, "PLN");
        given(item.price()).willReturn(plnPrice);

        sellStaticsLegacy.addSoldItemToStatistics(item);

        assertEquals(1,sellStaticsLegacy.getItemSold().get());
        assertEquals(100, sellStaticsLegacy.getMoneyEarnedInPLN().get());

        then(item).should().price();
    }
    @Test
    public void shouldNotAddItemPriceConvertedToPLNToSellStatistics() {
        var usdPrice = new Price(100, "USD");
        given(item.price()).willReturn(usdPrice);

        sellStaticsLegacy.addSoldItemToStatistics(item);

        assertEquals(1,sellStaticsLegacy.getItemSold().get());
        assertEquals(400, sellStaticsLegacy.getMoneyEarnedInPLN().get());

        then(item).should().price();
    }

}