package system.model;

import java.sql.Date; // Обязательно java.sql;

public class Purchase {
    private long purch_id;
    private long dealer_id;
    private Date purch_date;

    public Purchase() {

    }

    public long getPurch_id() {
        return purch_id;
    }

    public void setPurch_id(long purch_id) {
        this.purch_id = purch_id;
    }

    public long getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(long dealer_id) {
        this.dealer_id = dealer_id;
    }

    public Date getPurch_date() {
        return purch_date;
    }

    public void setPurch_date(Date purch_date) {
        this.purch_date = purch_date;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "purch_id=" + purch_id +
                ", dealer_id=" + dealer_id +
                ", purch_date=" + purch_date +
                '}';
    }
}
