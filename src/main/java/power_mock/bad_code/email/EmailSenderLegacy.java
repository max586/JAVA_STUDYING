package power_mock.bad_code.email;

import power_mock.bad_code.client.Client;
import power_mock.bad_code.item.Item;

public class EmailSenderLegacy {
    public static void sendEmail(Item item, Client client){
        System.out.println("have just purchased"+client.getName()+item.name());
    }
}
