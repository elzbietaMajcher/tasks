package taskB3;

public class Currency {

    private String name;
    private String price_usd;

    public Currency(String name, String price_usd) {
        this.name = name;
        this.price_usd = price_usd;
    }

    @Override
    public String toString() {
        return name + ": " + price_usd;
    }

}


