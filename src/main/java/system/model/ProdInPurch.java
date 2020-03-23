package system.model;

public class ProdInPurch {
    private long prod_id;
    private long purch_id;
    private int amount;
    private int price;

    public ProdInPurch(){

    }

    public long getProd_id() {
        return prod_id;
    }

    public void setProd_id(long prod_id) {
        this.prod_id = prod_id;
    }

    public long getPurch_id() {
        return purch_id;
    }

    public void setPurch_id(long purch_id) {
        this.purch_id = purch_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProdInPurch{" +
                "prod_id=" + prod_id +
                ", purch_id=" + purch_id +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
