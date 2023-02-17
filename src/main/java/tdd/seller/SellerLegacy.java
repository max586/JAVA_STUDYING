package tdd.seller;

import tdd.client.Client;
import tdd.email.EmailSenderLegacy;
import tdd.item.Item;

public class SellerLegacy {
    private SellStaticsLegacy sellStaticsLegacy;
    private EmailSenderLegacy emailSenderLegacy;

    public SellerLegacy(SellStaticsLegacy sellStaticsLegacy, EmailSenderLegacy emailSenderLegacy)
    {
        this.sellStaticsLegacy = sellStaticsLegacy;
        this.emailSenderLegacy = emailSenderLegacy;
    }

    public void sellItem(Item item, Client client) {
        emailSenderLegacy.sendEmail(item, client);
        sellStaticsLegacy.addSoldItemToStaistics(item);
    }
}
