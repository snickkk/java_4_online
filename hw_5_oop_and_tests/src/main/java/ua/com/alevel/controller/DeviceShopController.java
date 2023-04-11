package ua.com.alevel.controller;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.service.DeviceShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class DeviceShopController {
    private DeviceShopService deviceShopService = new DeviceShopService();


    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your options");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1. If you want to add a device, enter- 1");
        System.out.println("2. If you want to add a shop, enter - 2");
        System.out.println("3. If you want find device, please enter id - 3");
        System.out.println("4. If you want find shop, please enter id - 4");
        System.out.println("5. If You want to update a device, please enter - 5");
        System.out.println("6. If You want to update a shop, please enter - 6");
        System.out.println("7. If you want delete device, please enter id - 7");
        System.out.println("8. If you want delete shop, please enter id - 8");
        System.out.println("9. If you want find all device, please enter - 9");
        System.out.println("10. If you want find all shop, please enter - 10");
        System.out.println("11. Press to exit the offer - 11");
        System.out.println();
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> createDevice(reader);
            case "2" -> createShop(reader);
            case "3" -> findDevice(reader);
            case "4" -> findShop(reader);
            case "5" -> updateDevice(reader);
            case "6" -> updateShop(reader);
            case "7" -> deleteDevice(reader);
            case "8" -> deleteShop(reader);
            case "9" -> findAllDevice();
            case "10" -> findAllShop();
            case "11" -> exit();
        }
        menu();
    }

    private void createDevice(BufferedReader reader) throws IOException {
        System.out.println("to add a new device.");
        System.out.println("Please enter device model.");
        String model = reader.readLine();
        System.out.println("Please enter device price.");
        String price = reader.readLine();
        System.out.println("Please enter city of origin.");
        String city = reader.readLine();
        Device device = new Device();
        device.setModel(model);
        device.setPrice(price);
        device.setCity(city);
        deviceShopService.createDevice(device);
    }

    private void createShop(BufferedReader reader) throws IOException {
        System.out.println("Create shop");
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter country");
        String country = reader.readLine();
        Shop shop = new Shop();
        shop.setShopName(name);
        shop.setCity(country);
        deviceShopService.createShop(shop);
    }

    private void findDevice(BufferedReader reader) throws IOException {
        System.out.println("You want to find device");
        System.out.println("Please enter device Id");
        String deviceId = reader.readLine();
        Optional<Device> device = deviceShopService.getDevice(deviceId);
        if (device.isEmpty()) {
            System.out.println("Wrong ID");
        } else {
            System.out.println(device);
        }

    }

    private void findShop(BufferedReader reader) throws IOException {
        System.out.println("You want to find shop");
        System.out.println("Please enter shop Id");
        String shopId = reader.readLine();
        Optional<Shop> shop = deviceShopService.getShop(shopId);
        if (shop.isEmpty()) {
            System.out.println("Wrong ID");
        } else {
            System.out.println(shop);
        }

    }

    private void updateDevice(BufferedReader reader) throws IOException {
        System.out.println("Let's update devices information. To start, please enter devices ID:");
        String deviceId = reader.readLine();
        Optional<Device> device1 = DbStorage.getInstance().getDevice(deviceId);
        if (device1.isEmpty()) {
            System.out.println("This device does not exist.");
        } else {
            Device device = device1.get();
            System.out.println("Please enter device new model:");
            String deviceModel = reader.readLine();
            device.setModel(deviceModel);
            System.out.println("Please enter devices price:");
            String price = reader.readLine();
            device.setPrice(price);
            System.out.println("Please enter devices country:");
            String сity = reader.readLine();
            device.setCity(сity);
            System.out.println("Thank you, the devices information is updated.");
        }
    }

    private void updateShop(BufferedReader reader) throws IOException {
        System.out.println("Let's update shop's information. To start, please enter shop's ID:");
        String shopId = reader.readLine();
        Optional<Shop> shop1 = DbStorage.getInstance().getShop(shopId);
        if (shop1.isEmpty()) {
            System.out.println("This shop does not exist.");
        } else {
            Shop shop = shop1.get();
            System.out.println("Please enter shop's name:");
            String shopName = reader.readLine();
            shop.setShopName(shopName);
            System.out.println("Please enter devices country:");
            String city = reader.readLine();
            shop.setCity(city);
            System.out.println("Thank you, the shop's information is updated.");
        }
    }

    private void deleteDevice(BufferedReader reader) throws IOException {
        System.out.println("Delete by device id");
        String Id = reader.readLine();
        deviceShopService.deleteDevice(Id);
    }

    private void deleteShop(BufferedReader reader) throws IOException {
        System.out.println("Delete by shop id");
        String Id = reader.readLine();
        deviceShopService.deleteShop(Id);
    }

    private void findAllDevice() {
        System.out.println("Find all devices");
        List<Device> devices = deviceShopService.findAllDevice();
        System.out.println("devices " + devices);
    }

    private void findAllShop() {
        System.out.println("Find all shop");
        List<Shop> shops = deviceShopService.findAllShop();
        System.out.println("shops " + shops);

    }

    private void exit() {
        System.exit(0);
    }
}
