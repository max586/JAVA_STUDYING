package tdd.newsletter;

import tdd.client.Client;

import java.util.Collection;
import java.util.HashSet;

public class NewsLetterService {
    private Collection<Client> clients = new HashSet<>();

    public NewsLetterService subscribe(Client client) {
        this.clients.add(client);
        return this;
    }
    public void sendMessage(Message message) {
        for(var client: clients) {
            client.receiveMessage(message);
        }
    }
}
