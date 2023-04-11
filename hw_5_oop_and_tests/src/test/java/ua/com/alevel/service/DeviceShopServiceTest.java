package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Device;
import ua.com.alevel.entity.Shop;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeviceShopServiceTest {
    private static final DeviceShopService deviceShopService = new DeviceShopService();

    private static int SHOP = 5;
    private static int DEVICE = 10;
    private static final String SHOPNAME = "testName";
    private static final String DEVICEMODEL = "testmodel";
    private static final String PRICE = "testPrice";
    private static final String CITY = "testCity";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < SHOP; i++) {
            Shop shop = generateShop(i);
            deviceShopService.createShop(shop);
        }
        for (int j = 0; j < DEVICE; j++) {
            Device device = generateDevice(j);
            deviceShopService.createDevice(device);
        }
    }
    private static Device generateDevice(int j) {
        Device device = new Device();
        device.setModel(DEVICEMODEL + j);
        device.setPrice(PRICE + j);
        device.setCity(CITY + j);
        return device;
    }

    private static Shop generateShop(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOPNAME + i);
        shop.setCity(CITY + i);
        return shop;
    }

    @Test
    @Order(1)
    void createShop() {
        Shop shop = generateShop(SHOP + 1);
        deviceShopService.createShop(shop);
        Assertions.assertEquals(deviceShopService.findAllShop().size(), SHOP + 1);
    }

    @Test
    @Order(2)
    void createDevice() {
        Device device = generateDevice(DEVICE + 1);
        deviceShopService.createDevice(device);
        Assertions.assertEquals(deviceShopService.findAllDevice().size(), DEVICE + 1);
    }

    @Test
    @Order(7)
    void findAllShop() {
        Shop shop = deviceShopService.findAllShop().get(0);
        Assertions.assertEquals(deviceShopService.findAllShop().size(), SHOP);
    }

    @Test
    @Order(8)
    void findAllDevice() {
        Device device = deviceShopService.findAllDevice().get(0);
        Assertions.assertEquals(deviceShopService.findAllDevice().size(), DEVICE);
    }


    @Test
    @Order(3)
    void deleteShop() {
                Shop shop = deviceShopService.findAllShop().get(0);
        deviceShopService.deleteShop(shop.getId());
        Assertions.assertEquals(deviceShopService.findAllShop().size(), SHOP);
    }

    @Test
    @Order(4)
    void deleteDevice() {
        Device device = deviceShopService.findAllDevice().get(0);
        deviceShopService.deleteDevice(device.getId());
        Assertions.assertEquals(deviceShopService.findAllDevice().size(), DEVICE );
    }

    @Test
    @Order(5)
    void updateShop() {
        Shop shop = deviceShopService.findAllShop().get(0);
        shop.setCity("Kiev");
        deviceShopService.updateShop(shop);
        Assertions.assertNotEquals(deviceShopService.findAllShop().get(0).getCity(), CITY);
    }

    @Test
    @Order(6)
    void updateDevice() {
        Device device = deviceShopService.findAllDevice().get(0);
        device.setPrice("1000");
        deviceShopService.updateDevice(device);
        Assertions.assertNotEquals(deviceShopService.findAllDevice().get(0).getPrice(), DEVICE);
    }
}