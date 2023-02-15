package junit;

public class Price {
    private int amount;
    private String currency;

    public Price(int amount, String currency) {
        if(amount<0){
            throw new IllegalArgumentException("amount must be positive!!!");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
