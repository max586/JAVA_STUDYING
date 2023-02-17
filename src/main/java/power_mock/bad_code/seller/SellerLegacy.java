package power_mock.bad_code.seller;

import power_mock.bad_code.email.EmailSenderLegacy;
import power_mock.bad_code.item.Item;
import power_mock.bad_code.client.Client;

public class SellerLegacy {
    private SellStaticsLegacy sellStaticsLegacy;

    public SellerLegacy() {
        this.sellStaticsLegacy = new SellStaticsLegacy();
    }

    public void sellItem(Item item, Client client) {
        EmailSenderLegacy.sendEmail(item, client);
        sellStaticsLegacy.addSoldItemToStatistics(item);
    }
}
