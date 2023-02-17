package power_mock.bad_code.seller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.FieldSetter;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import power_mock.bad_code.client.Client;
import power_mock.bad_code.common.Price;
import power_mock.bad_code.email.EmailSenderLegacy;
import power_mock.bad_code.item.Item;

import static org.mockito.BDDMockito.then;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EmailSenderLegacy.class, SellerLegacy.class, SellStaticsLegacy.class})
public class SellerLegacyTest {
    @Mock Item item;
    @Mock Client client;
    @Mock SellStaticsLegacy sellStatistics;
    SellerLegacy seller;
    //@Spy SellStaticsLegacy sellStatisticsSpy;

    private void powerMockInit() throws Exception {
        whenNew(SellStaticsLegacy.class).withNoArguments().thenReturn(sellStatistics);
        mockStatic(EmailSenderLegacy.class);
    }

    @Before
    public void setUp() throws Exception{
        powerMockInit();
        seller = new SellerLegacy();
        verifyNew(SellStaticsLegacy.class).withNoArguments();
    }

    @Test
    public void shouldSendEmailWhenItemSold() {
        seller.sellItem(item, client);
        verifyStatic(EmailSenderLegacy.class);
        EmailSenderLegacy.sendEmail(item,client);
    }

    @Test
    public void shouldAddItemToStaisticsWhenItemSold() throws Exception {
        seller.sellItem(item, client);
        then(sellStatistics).should().addSoldItemToStatistics(item);
    }

    /*@Test
    @Ignore
    public void checkSpy() throws Exception {
        var realPrice = new Price(100,"PLN");
        var realItem = new Item(1,"",realPrice);
        var realClient = new Client("email","name");

        //when(sell)
        FieldSetter.setField(seller, seller.getClass().getDeclaredField("sellStaticsLegacy"), sellStatisticsSpy);

        seller.sellItem(realItem, realClient);

        //verifyPrivate(sellStatisticsSpy).invoke("sayHello");
    }*/
}