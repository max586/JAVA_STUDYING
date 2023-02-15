package assertj;

public class ObjComposite implements ObjInt{
    ObjInt[] objects;
    public ObjComposite(ObjInt[] objects) {
        this.objects = objects;
    }
    @Override
    public void print() {
        for(var object: objects){
            object.print();
        }
    }
}
