package tdd.email;

import tdd.client.Client;
import tdd.item.Item;

public class EmailSenderLegacy {
    public void sendEmail(Item item, Client client){
        System.out.println("have just purchased"+client.getName()+item.name());
    }
}
