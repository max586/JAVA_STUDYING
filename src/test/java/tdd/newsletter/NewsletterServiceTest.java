package tdd.newsletter;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import tdd.client.Client;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/*
* + subscribed client should receive message
* + all subscribed clients should receive message
* - unsubscribed client should not receive message
* - not subscribed clients should not receive message
* + multi subscribers should receive message only once
* - unsubscribing of not subscribed client should not throw exception
* */
public class NewsletterServiceTest {
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Client client;
    @Mock Message message;

    @Test
    public void subscribedClientShouldReceiveMessage() {
        NewsLetterService newsLetter = new NewsLetterService();

        newsLetter.subscribe(client).sendMessage(message);

        then(client).should().receiveMessage(message);
    }
    @Test
    public void subscribedClientsShouldReceiveMessage() {
        NewsLetterService newsLetter = new NewsLetterService();
        Client client2 = mock(Client.class);

        newsLetter.subscribe(client).subscribe(client2)
                .sendMessage(message);

        then(client).should().receiveMessage(message);
        then(client2).should().receiveMessage(message);
    }
    @Test
    public void multiSubscribersShouldReceiveMessageOnlyOnce() {
        NewsLetterService newsLetter = new NewsLetterService();

        newsLetter.subscribe(client).
                subscribe(client).sendMessage(message);

        then(client).should(times(1)).receiveMessage(message);
    }
}
