package power_mock.bad_code.client;

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
}
