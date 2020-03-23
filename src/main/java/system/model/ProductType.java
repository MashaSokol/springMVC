package system.model;

public class ProductType {
    private long type_id;
    private String name;

    public ProductType(){

    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductTypes{" +
                "type_id=" + type_id +
                ", name='" + name + '\'' +
                '}';
    }
}

