package ua.com.alevel.dao;

import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface DeviceShopDao  {

    void createShop(Shop shop);
    void createDevice(Device product);
    void updateShop(Shop shop);
    void updateDevice(Device product);
    void deleteShop(String id);
    void deleteDevice(String id);
    List<Shop> findAllShop();
    List<Device> findAllDevice();
    Optional<Shop> getShop(String id);
    Optional<Device> getDevice(String id);

}
