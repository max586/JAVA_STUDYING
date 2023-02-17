package power_mock.testable_code.common;

import java.util.Objects;

public final class Price {
    private final int amount;
    private final String currency;

    public Price(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int amount() {
        return amount;
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Price) obj;
        return this.amount == that.amount &&
                Objects.equals(this.currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "Price[" +
                "amount=" + amount + ", " +
                "currency=" + currency + ']';
    }
}
