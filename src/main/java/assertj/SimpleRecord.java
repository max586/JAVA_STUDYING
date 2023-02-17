package assertj;

import java.util.Objects;

public final class SimpleRecord {
    public static final SimpleRecord DEFAULT = new SimpleRecord(0, "", ' ', 0.0);
    private final int n;
    private final String s;
    private final char c;
    private final double d;

    public SimpleRecord(int n, String s, char c, double d) {
        this.n = n;
        this.s = s;
        this.c = c;
        this.d = d;
    }

    public int n() {
        return n;
    }

    public String s() {
        return s;
    }

    public char c() {
        return c;
    }

    public double d() {
        return d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SimpleRecord) obj;
        return this.n == that.n &&
                Objects.equals(this.s, that.s) &&
                this.c == that.c &&
                Double.doubleToLongBits(this.d) == Double.doubleToLongBits(that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, s, c, d);
    }

    @Override
    public String toString() {
        return "SimpleRecord[" +
                "n=" + n + ", " +
                "s=" + s + ", " +
                "c=" + c + ", " +
                "d=" + d + ']';
    }

}
