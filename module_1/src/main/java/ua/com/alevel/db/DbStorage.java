package ua.com.alevel.db;

import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

import java.util.Arrays;
import java.util.UUID;

public class DbStorage {
    private static Device[] devices = new Device[10];
    private static Shop[] shops = new Shop[6];
    private static Device[] productsArray;
    private static Shop[] shopsArray;

    private DbStorage() {
    }

    public static void addDevice(Device device) {
        device.setId(generateDeviceId());

        for (int i = 0; i < devices.length; i++) {
            if (devices[i] == null) {
                devices[i] = device;
                break;

            }
            if (devices[devices.length - 1] != null) {
                productsArray = new Device[devices.length * 2];
                for (int j = 0; j < devices.length; j++) {
                    productsArray[j] = devices[j];
                }
                devices = productsArray;
            }
        }
    }

    public static void addShop(Shop shop) {
        shop.setId(generateShopId());

        for (int i = 0; i < shops.length; i++) {
            if (shops[i] == null) {
                shops[i] = shop;
                break;

            }
            if (shops[shops.length - 1] != null) {
                shopsArray = new Shop[shops.length * 2];
                for (int j = 0; j < shops.length; j++) {
                    shopsArray[j] = shops[j];
                }
                shops = shopsArray;
            }
        }
    }

    private static String generateDeviceId() {
        String id = UUID.randomUUID().toString();

        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {

                if (devices[i].getId().equals(id)) {
                    return generateDeviceId();
                }
            }
        }
        return id;
    }

    public static String generateShopId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < shops.length; i++) {
            if (shops[i] != null) {
                if (shops[i].getId().equals(id)) {
                    return generateShopId();
                }
            }
        }
        return id;
    }

    public static void deleteDevice(String id) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                if (devices[i].getId().equals(id)) {
                    devices[i] = null;
                    return;
                }

            }
        }
        System.out.println("Wrong id");
    }

    public static void deleteShop(String id) {
        for (int i = 0; i < shops.length; i++) {
            if (shops[i] != null) {
                if (shops[i].getId().equals(id)) {
                    shops[i] = null;
                    return;
                }

            }
        }
        System.out.println("Wrong id");
    }

    public static Device getDevice(String id) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                if (devices[i].getId().equals(id)) {
                    return devices[i];
                }
            }
        }
        return null;
    }

    public static void attach(String deviceId, String shopId) {
        attachShopToProduct(deviceId, shopId);
    }

    private static void attachShopToProduct(String shopId, String deviceId) {
        Shop shop = getShop(shopId);
        String[] devices = shop.getShopIdList();
        devices = addUniqueShopToDevice(devices, deviceId);
        shop.setShopIdList(devices);
    }

    private static String[] addUniqueShopToDevice(String[] array, String element) {
        int emptyIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(element)) {
                    return array;
                }
            } else if (emptyIndex == -1) {
                emptyIndex = i;
            }
        }

        if (emptyIndex == -1) {
            String[] temp = Arrays.copyOf(array, array.length + 0);
            array = temp;
        }
        array[emptyIndex] = element;
        return array;
    }

    public static Shop getShop(String id) {
        for (int i = 0; i < shops.length; i++) {
            if (shops[i] != null) {
                if (shops[i].getId().equals(id)) {
                    return shops[i];
                }
            }
        }
        return null;
    }

    public static Device[] getDevice() {
        return devices;
    }

    public static Shop[] getShop() {
        return shops;
    }

    public static void deleteProductToShop(String productId, String shopId) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                if (devices[i].getId().equals(productId)) {
                    devices[i] = null;
                    for (i = 0; i < shops.length; i++) {
                        if (shops[i] != null) {
                            if (shops[i].getId().equals(shopId)) {
                                shops[i] = null;
                                return;
                            }

                        }
                    }
                    System.out.println("Wrong id");
                }
            }
        }
    }
}

