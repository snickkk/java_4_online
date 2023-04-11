package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Shop  extends  BaseEntity{

    private Set<String> shopIdList = new HashSet<>();

    private String shopName;

    private String city;

    public Set<String> getShopIdList() {
        return shopIdList;
    }

    public void setShopIdList(Set<String> shopIdList) {
        this.shopIdList = shopIdList;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String country) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Shop{" +
                ", id='" + getId() + '\'' +
                "shopIdList=" + shopIdList +
                ", shopName='" + shopName + '\'' +
                ", country='" + city + '\'' +
                '}';
    }
}
