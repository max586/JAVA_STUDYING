package assertj;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ObjTest {
    @Test
    public void TestRecursiveComparing(){
        ObjInt objComposite1 = new ObjComposite(new ObjInt[]{new Obj(1), new Obj(2), new ObjComposite(new ObjInt[]{new Obj(1), new Obj(2)})});
        ObjInt objComposite2 = new ObjComposite(new ObjInt[]{new Obj(1), new Obj(2), new ObjComposite(new ObjInt[]{new Obj(1), new Obj(2)})});
        assertThat(objComposite1).as("different references").isNotEqualTo(objComposite2);
        assertThat(objComposite2).as("comparing recursively").usingRecursiveComparison().isEqualTo(objComposite2);
    }
}