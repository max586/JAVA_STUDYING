package assertj;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.assertj.core.api.BDDAssertions.then;

public class SimpleRecordTest {

    Condition<SimpleRecord> noZeroNumberRecordCond = new Condition<>(simpleRecord -> simpleRecord.n() != 0, "mmmm");
    List<SimpleRecord> records = List.of(SimpleRecord.DEFAULT, new SimpleRecord(1,"wsw",'a',2.9), new SimpleRecord(0, "qoo",'b',9.9),
            new SimpleRecord(-1,null,' ',0.0));

    @Test
    public void testDefaultRecord() {
        var r1 = SimpleRecord.DEFAULT;
        assertThat(r1.s()).as("record name test: %s", r1.s()).isEqualTo("");
    }
    @Test
    public void testCollectionOfRecords(){
        assertThat(records).filteredOnNull("s").singleElement().isEqualTo(new SimpleRecord(-1,null,' ',0.0));
        assertThat(records).filteredOn(r->r.s()!=null && !r.s().isEmpty()).doesNotContain(SimpleRecord.DEFAULT).
                hasSize(2).filteredOn(noZeroNumberRecordCond).singleElement().isEqualTo(new SimpleRecord(1,"wsw",'a',2.9));
        assertThat(records).extracting("c", Character.class).contains('a');
        assertThat(records).extracting("n","d").contains(tuple(1,2.9));
    }
    @Test
    public void testComparing(){
        var r1 = new SimpleRecord(1,"",' ',1.1);
        var r2 = SimpleRecord.DEFAULT;
        assertThat(r1).usingComparator(Comparator.comparing(SimpleRecord::s)).isEqualTo(r2);
    }
    @Test
    public void testException(){
        Throwable thrown = catchThrowable(() -> new SimpleRecord(Integer.parseInt("1.1"), "", ' ',0.0));
        then(thrown).isInstanceOf(NumberFormatException.class);
        assertThatNoException().isThrownBy(()->new SimpleRecord(Integer.parseInt("1"), "", ' ', 0.0));
    }
}