package junit;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class PriceTest {
    private static final String ANY_CURRENCY = "PLN";
    private static final int ANY_AMOUNT = 0;


    @Test
    @Parameters({"10,PLN","100,US"})
    public void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Price price = new Price(amount, currency);

        assertEquals(amount,price.getAmount());
        assertEquals(currency, price.getCurrency());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIAEIfAmountIsNegative(){
        new Price(-1,ANY_CURRENCY);
    }

}