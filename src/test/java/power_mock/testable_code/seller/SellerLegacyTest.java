package power_mock.testable_code.seller;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import power_mock.testable_code.client.Client;
import power_mock.testable_code.email.EmailSenderLegacy;
import power_mock.testable_code.item.Item;
import static org.mockito.BDDMockito.then;

public class SellerLegacyTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock Item item;
    @Mock Client client;
    @Mock SellStaticsLegacy sellStaistics;
    @Mock EmailSenderLegacy emailSender;

    @InjectMocks SellerLegacy seller;

    @Test
    public void shouldSendEmailWhenItemSold() {
        seller.sellItem(item, client);
        then(emailSender).should().sendEmail(item,client);
    }

    @Test
    public void shouldAddItemToStaisticsWhenItemSold() {
        seller.sellItem(item, client);
        then(sellStaistics).should().addSoldItemToStaistics(item);
    }
}