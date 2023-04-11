package ua.com.alevel.service;

import ua.com.alevel.dao.DeviceShopDao;
import ua.com.alevel.dao.DeviceShopDao1;
import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public class DeviceShopService {
    private final DeviceShopDao deviceShopDao = new DeviceShopDao1();


    public void createShop(Shop shop) {
        deviceShopDao.createShop(shop);
    }

    public void createDevice(Device device) {
        deviceShopDao.createDevice(device);
    }

    public List<Shop> findAllShop() {
        return deviceShopDao.findAllShop();
    }

    public List<Device> findAllDevice() {
        return deviceShopDao.findAllDevice();
    }

    public Optional<Shop> getShop(String id) {
        return deviceShopDao.getShop(id);
    }

    public Optional<Device> getDevice(String id) {
        return deviceShopDao.getDevice(id);
    }

    public void deleteShop(String id) {
        deviceShopDao.deleteShop(id);
    }

    public void deleteDevice(String id) {
        deviceShopDao.deleteDevice(id);
    }

    public void updateShop(Shop shop) {
        deviceShopDao.updateShop(shop);
    }

    public void updateDevice(Device device) {
        deviceShopDao.updateDevice(device);
    }
}
