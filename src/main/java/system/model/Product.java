package system.model;

public class Product {
    private long prod_id;
    private String name;
    private long type_id;

    public Product(){

    }

    public long getProd_id() {
        return prod_id;
    }

    public void setProd_id(long prod_id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "prod_id=" + prod_id +
                ", name='" + name + '\'' +
                ", type_id=" + type_id +
                '}';
    }
}
