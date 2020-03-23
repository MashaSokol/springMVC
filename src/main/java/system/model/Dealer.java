package system.model;


public class Dealer {
    private long dealer_id;
    private String fName;
    private String sName;
    private String lName;
    private long phone_number;
    private String address;
    private String description;

    public Dealer() {

    }

    public long getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(long dealer_id) {
        this.dealer_id = dealer_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dealers{" +
                "dealer_id=" + dealer_id +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", lName='" + lName + '\'' +
                ", phone_number=" + phone_number +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
