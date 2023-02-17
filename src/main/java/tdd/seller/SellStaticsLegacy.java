package tdd.seller;

import tdd.common.CurrencyExchangerLegacy;
import tdd.item.Item;

import java.util.concurrent.atomic.AtomicLong;

public class SellStaticsLegacy {
    private AtomicLong itemSold = new AtomicLong();
    private AtomicLong moneyEarnedInPLN = new AtomicLong();

    public AtomicLong getItemSold() {
        return itemSold;
    }

    public AtomicLong getMoneyEarnedInPLN() {
        return moneyEarnedInPLN;
    }

    public void addSoldItemToStaistics(Item item) {
        itemSold.incrementAndGet();
        var price = item.price();
        if(price.currency().equals("USD")){
            moneyEarnedInPLN.getAndAdd(CurrencyExchangerLegacy.exchangeUSDToPLN(price.amount()));
        } else{
            moneyEarnedInPLN.getAndAdd(price.amount());
        }
    }
}
