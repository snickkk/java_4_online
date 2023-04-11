package ua.com.alevel;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DeviceInterface {

    public static void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your options");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private static void menu() {
        System.out.println();
        System.out.println("1. If you would like to add a device name, please enter - 1");
        System.out.println("2. If you would like to add a shop name, please enter - 2");
        System.out.println("3. If you want find device, please enter id - 3");
        System.out.println("4. If you want find shop, please enter id - 4");
        System.out.println("5. If You want to update a device, please enter - 5");
        System.out.println("6. If You want to update a shop, please enter - 6");
        System.out.println("7. If You want to attach a device to the shop, please enter - 7");
        System.out.println("8. If You want to delete device to shop - 8");
        System.out.println("9. If you want delete device, please enter id - 9");
        System.out.println("10. If you want delete shop, please enter id - 10");
        System.out.println("11. If you want find all device , please enter - 11");
        System.out.println("12. If you want find all shop, please enter - 12");
        System.out.println("13. Press to exit the offer - 13");
        System.out.println();
    }

    private static void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                createDevice(reader);
                break;
            case "2":
                createShop(reader);
                break;
            case "3":
                findDevice(reader);
                break;
            case "4":
                findShop(reader);
                break;
            case "5":
                updateDevice(reader);
                break;
            case "6":
                updateShop(reader);
                break;
            case "7":
                attachShopToDevice(reader);
                break;
            case "8":
                deleteDeviceToShop(reader);
                break;
            case "9":
                deleteDevice(reader);
                break;
            case "10":
                deleteShop(reader);
                break;
            case "11":
                findAllDevice();
                break;
            case "12":
                findAllShop();
                break;
            case "13":
                exit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + select);
        }
        menu();
    }

    private static void createDevice(BufferedReader reader) throws IOException {
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
        DbStorage.addDevice(device);
    }

    private static void createShop(BufferedReader reader) throws IOException {
        System.out.println("Create shop");
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter city");
        String city = reader.readLine();
        Shop shop = new Shop();
        shop.setShopName(name);
        shop.setCity(city);
        DbStorage.addShop(shop);
    }

    private static void findDevice(BufferedReader reader) throws IOException {
        System.out.println("Find device by id");
        String id = reader.readLine();
        Device device = DbStorage.getDevice(id);
        System.out.println("Device = " + device);
    }

    private static void findShop(BufferedReader reader) throws IOException {
        System.out.println("Find shop by id");
        String id = reader.readLine();
        Shop shop = DbStorage.getShop(id);
        System.out.println("shop = " + shop);
    }

    private static void updateDevice(BufferedReader reader) throws IOException {
        System.out.println("Let's update devices information. To start, please enter devices ID:");
        String deviceId = reader.readLine();
        Device device = DbStorage.getDevice(deviceId);
        if (device == null) {
            System.out.println("This device does not exist.");
        } else {
            System.out.println("Please enter device model:");
            String model = reader.readLine();
            device.setModel(model);
            System.out.println("Please enter devices price:");
            String price = reader.readLine();
            device.setPrice(price);
            System.out.println("Please enter devices city:");
            String city = reader.readLine();
            device.setCity(city);
            System.out.println("Thank you, the devices information is updated.");
        }
    }

    private static void updateShop(BufferedReader reader) throws IOException {
        System.out.println("Let's update shop's information. To start, please enter shop's ID:");
        String shopId = reader.readLine();
        Shop shop = DbStorage.getShop(shopId);
        if (shop == null) {
            System.out.println("This shop does not exist.");
        } else {
            System.out.println("Please enter shop's name:");
            String shopName = reader.readLine();
            shop.setShopName(shopName);
            System.out.println("Please enter devices city:");
            String city = reader.readLine();
            shop.setCity(city);
            System.out.println("Thank you, the shop's information is updated.");
        }
    }

    private static void attachShopToDevice(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the device to shop. To start, please enter shop's ID:");
        String deviceId = reader.readLine();
        System.out.println("Then please enter devices ID:");
        String shopId = reader.readLine();
        if (deviceId == null || shopId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(deviceId, shopId);
            System.out.println("Attachment is successful.");
        }


    }

    private static void deleteDeviceToShop(BufferedReader reader) throws IOException {
        System.out.println("Delete device to shop");
        System.out.println("Please enter shop id");
        String shopId = reader.readLine();
        System.out.println("Please enter device id");
        String deviceId = reader.readLine();
        DbStorage.deleteProductToShop(deviceId, shopId);
    }

    private static void deleteDevice(BufferedReader reader) throws IOException {
        System.out.println("Delete by device id");
        String id = reader.readLine();
        DbStorage.deleteDevice(id);
    }

    private static void deleteShop(BufferedReader reader) throws IOException {
        System.out.println("Delete by shop id");
        String id = reader.readLine();
        DbStorage.deleteShop(id);
    }


    private static void findAllDevice() {
        System.out.println("Find all device");
        Device[] device = DbStorage.getDevice();
        System.out.println(Arrays.toString(device));
    }

    private static void findAllShop() {
        System.out.println("Find all shop");
        Shop[] shops = DbStorage.getShop();
        System.out.println(Arrays.toString(shops));

    }

    private static void exit() {
        System.exit(0);
    }
}
