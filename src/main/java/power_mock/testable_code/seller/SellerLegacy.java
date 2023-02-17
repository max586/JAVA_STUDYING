package power_mock.testable_code.seller;

import power_mock.testable_code.client.Client;
import power_mock.testable_code.email.EmailSenderLegacy;
import power_mock.testable_code.item.Item;

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
