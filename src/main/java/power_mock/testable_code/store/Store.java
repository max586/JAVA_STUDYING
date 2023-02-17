package power_mock.testable_code.store;

import mockito.ClientLegacy;
import mockito.Item;
import mockito.SellerLegacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private Map<Long, Item> items;
    private SellerLegacy seller;

    public Store(SellerLegacy seller) {
        this.items = new ConcurrentHashMap<>(128);
        this.seller = seller;
    }

    public Store addItem(Item item){
        items.put(item.id(), item);
        return this;
    }
    public Optional<Item> getItem(long itemId){return Optional.ofNullable(items.get(itemId));}
    public Collection<Item> getItems(){return new ArrayList<>(items.values());}
    public void sellItem(long id, ClientLegacy client){
        getItem(id).ifPresent(i->seller.sellItem(i,client));
    }

    @Override
    public String toString() {
        return "Store{" + "items=" + items + '}';
    }
}
