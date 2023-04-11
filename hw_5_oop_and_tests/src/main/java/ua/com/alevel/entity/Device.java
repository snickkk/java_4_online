package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Device  extends BaseEntity{

    private Set<String> deviceIdList = new HashSet<>();
    private String model;
    private String price;
    private String city;



    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<String> getDeviceIdList() {
        return deviceIdList;
    }


    @Override
    public String toString() {
        return "Device{" +
                ", id='" + getId() + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
