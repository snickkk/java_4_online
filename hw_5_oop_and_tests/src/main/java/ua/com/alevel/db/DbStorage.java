package ua.com.alevel.db;

import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DbStorage {
    private List<Device> devices= new ArrayList<>();
    private List<Shop> shops = new ArrayList<>();
    private static DbStorage instance;

    private DbStorage() {
    }

    public static DbStorage getInstance() {
        if (instance == null) {
            instance = new DbStorage();
        }
        return instance;
    }


    public void addShop(Shop shop) {
        String id = generateShopId();
        shop.setId(id);
        shops.add(shop);
    }

    public void addDevice(Device device) {
        String id = generateDeviceIdId();
        device.setId(id);
        devices.add(device);
    }

    public List<Shop> findAllShop() {
        return new ArrayList<>(shops);
    }

    public List<Device> findAllDevice() {
        return new ArrayList<>(devices);
    }

    public Optional<Shop> getShop(String id) {
        return shops
                .stream()
                .filter(shop -> shop.getId().equals(id))
                .findFirst();
    }

    public Optional<Device> getDevice(String id) {
        return devices
                .stream()
                .filter(device -> device.getId().equals(id))
                .findFirst();
    }

    private String generateDeviceIdId() {
        String id = UUID.randomUUID().toString();
        if (devices.stream().anyMatch(device -> device.getId().equals(id))) {
            return generateDeviceIdId();
        }
        return id;
    }

    private String generateShopId() {
        String id = UUID.randomUUID().toString();
        if (shops.stream().anyMatch(shop -> shop.getId().equals(id))) {
            return generateShopId();
        }
        return id;
    }

    public void deleteShop(String id) {
        shops.stream().map(Shop::getShopIdList).forEach(shop -> shop.remove(id));
        shops.removeIf(shop -> shop.getId().equals(id));
    }

    public void deleteDevice(String id) {
        devices.stream().map(Device::getDeviceIdList).forEach(device -> device.remove(id));
        devices.removeIf(device -> device.getId().equals(id));
    }

    public void updateShop(Shop shop) {
        shops.remove(shop);
        shops.add(shop);
    }

    public void updateDevice(Device device) {
        devices.remove(device);
        devices.add(device);
    }
}
