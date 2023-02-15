package junit;

import java.util.concurrent.atomic.AtomicLong;

public class Item {
    private static AtomicLong itemsNumber = new AtomicLong(0);

    private Price price;
    private String name;
    private long id;


    public Item(Price price, String name) {
        this.price = price;
        this.name = name;
        id = itemsNumber.getAndAdd(1);
    }
    public Price getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
}
