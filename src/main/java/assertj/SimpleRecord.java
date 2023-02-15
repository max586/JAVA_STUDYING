package assertj;

public record SimpleRecord(int n, String s, char c, double d) {
    public static final SimpleRecord DEFAULT = new SimpleRecord(0,"",' ',0.0);
}
