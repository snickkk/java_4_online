package ua.com.alevel.entity;

import java.util.Arrays;

public class Shop extends BaseEntity {

    private static Shop[] shopsArray = new Shop[10];
    private String[] shopIdList = new String[10];
    private String shopName;
    private String city;

    public static Shop[] getShopsArray() {
        return shopsArray;
    }

    public static void setShopsArray(Shop[] shopsArray) {
        Shop.shopsArray = shopsArray;
    }

    public String[] getShopIdList() {
        return shopIdList;
    }

    public void setShopIdList(String[] shopIdList) {
        this.shopIdList = shopIdList;
    }

    public String shoopName() {

  return shopName;
    }

    public void setShopName(String shopName) {
        if (shopName.matches(".*\\d.*")) {
            System.out.println("Incorrect introduction of the name");
        } else {
            this.shopName = shopName;
        }
        this.shopName = shopName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.matches(".*\\d.*")) {
            System.out.println("Incorrect introduction of the city");
        } else {
            this.city = city;
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + getId()  +
                ", shopName='" + shopName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


