package power_mock.bad_code.item;

import power_mock.bad_code.common.Price;

import java.util.Objects;

public class Item {
    private long id;
    private String name;
    private Price price;

    public Item(long id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Price price() {
        return price;
    }
}
