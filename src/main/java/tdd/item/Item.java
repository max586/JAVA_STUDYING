package tdd.item;

import tdd.common.Price;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Item) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Item[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "price=" + price + ']';
    }
}
