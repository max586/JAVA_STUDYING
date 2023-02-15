package assertj;

public class Obj implements ObjInt{
    public int field;
    public Obj(int field) {
        this.field = field;
    }
    @Override
    public void print() {
        System.out.println(field);
    }
}
