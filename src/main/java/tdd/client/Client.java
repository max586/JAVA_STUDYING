package tdd.client;

import tdd.newsletter.Message;

public class Client {
    private String emailAddress;
    private String name;

    public Client(String emailAddress, String name) {
        this.emailAddress = emailAddress;
        this.name = name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public void receiveMessage(Message message) {

    }
}
