package ua.com.alevel.entity;

import java.util.Arrays;

public class Device extends BaseEntity {

    private static Device[] devicesArray = new Device[10];
    private String[] deviceIdList = new String[10];
    private String model;
    private String price;
    private String city;

    public static Device[] getDevicesArray() {
        return devicesArray;
    }

    public static void setDevicesArray(Device[] devicesArray) {
        Device.devicesArray = devicesArray;
    }

    public String[] getDeviceIdList() {
        return deviceIdList;
    }

    public void setDeviceIdList(String[] deviceIdList) {
        this.deviceIdList = deviceIdList;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.matches(".*\\d.*")){
            System.out.println("Incorrect introduction of the device model");
        }else {
        this.model = model;
        }
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
        if (city.matches(".*\\d.*")){
            System.out.println("Incorrect introduction of the city");
        }else {
        this.city = city;
    }
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + getId() +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", country='" + city + '\'' +
                '}';
    }
}
