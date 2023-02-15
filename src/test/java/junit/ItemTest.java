package junit;

import static org.junit.Assert.*;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class ItemTest {
    public static final String ANY_STRING = "anyString";
    private static Set<Long> uniqueIds = new HashSet<>();

    Price price = new Price(0,"PLN");

    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();
    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();

    @Test
    public void shouldSetUniqueIds() {
        var item = new Item(price, ANY_STRING);
        var item2 = new Item(price, ANY_STRING);

        assertNotEquals("Items Ids should be unique", item.getId(), item2.getId());
    }

    @Repeating(repetition = 10)
    @Concurrent(count = 10)
    @Test
    public void shouldSetUniqueIdsConcurrent() {
        var item = new Item(price, ANY_STRING);
        System.out.println(item.getId());

        assertTrue(uniqueIds.add(item.getId()));
    }

    @Ignore("ignored example test")
    @Test
    public void ignoredTest() throws IOException {
        System.out.println("should never be executed");
    }
}