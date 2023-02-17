package power_mock.testable_code.email;

import power_mock.testable_code.client.Client;
import power_mock.testable_code.item.Item;

public class EmailSenderLegacy {
    public void sendEmail(Item item, Client client){
        System.out.println("have just purchased"+client.getName()+item.name());
    }
}
