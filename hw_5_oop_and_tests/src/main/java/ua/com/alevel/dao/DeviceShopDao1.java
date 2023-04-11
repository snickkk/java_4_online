package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public class DeviceShopDao1 implements DeviceShopDao{
    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public void createShop(Shop shop) { dbStorage.addShop(shop);

    }

    @Override
    public void createDevice(Device device) {
        dbStorage.addDevice(device);

    }

    @Override
    public void updateShop(Shop shop) {
        dbStorage.updateShop(shop);

    }

    @Override
    public void updateDevice(Device device) {
        dbStorage.updateDevice(device);

    }

    @Override
    public void deleteShop(String id) {
        dbStorage.deleteShop(id);
    }

    @Override
    public void deleteDevice(String id) {
        dbStorage.deleteDevice(id);

    }

    @Override
    public List<Shop> findAllShop() {
        return  dbStorage.findAllShop();
    }

    @Override
    public List<Device> findAllDevice() {
        return dbStorage.findAllDevice();
    }

    @Override
    public Optional<Shop> getShop(String id) {
        return dbStorage.getShop(id);
    }

    @Override
    public Optional<Device> getDevice(String id) {
        return dbStorage.getDevice(id);
    }
}
