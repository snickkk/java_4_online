package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DeviceInterface {
    public static void start() throws IOException, IOException {
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
        System.out.println("1. If you would like to add a device , please enter - 1");
        System.out.println("2. If you want find device, please enter name - 2");
        System.out.println("3. If you want delete device, please enter name - 3");
        System.out.println("4. If you want find all device, please enter - 4 ");
        System.out.println("5. If you want close application, please enter -5");
        System.out.println();
    }

    private static void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                createDevice(reader);
                break;
            case "2":
                findPhoneModel(reader);
                break;
            case "3":
                deleteDevice(reader);
                break;
            case "4":
                findAll();
                break;
            case "5":
                exit();
                break;
        }
        menu();
    }

    private static void createDevice(BufferedReader reader) throws IOException {
        System.out.println("to add a new device.");
        System.out.println("Please enter phone brand.");
        String brand = reader.readLine();
        System.out.println("Please enter model Phone.");
        String modelPhone = reader.readLine();
        System.out.println("Please enter phone memory.");
        int memory = Integer.parseInt(reader.readLine());
        System.out.println("Please enter  phone color.");
        String color = reader.readLine();
        System.out.println("Please enter  phone price.");
        int price = Integer.parseInt(reader.readLine());
        Device device = new Device();
        device.setBrand(brand);
        device.setModelPhone(modelPhone);
        device.setMemory(memory);
        device.setColor(color);
        device.setPrice(price);
        DeviceStorage.addDevice(device);
    }

    private static void findPhoneModel(BufferedReader reader) throws IOException {
        System.out.println("Find Model phone");
        String model = reader.readLine();
        Device device = DeviceStorage.getModel(model);
        System.out.println("device = " + device);

    }

    private static void deleteDevice(BufferedReader reader) throws IOException {
        System.out.println("Delete by Model phone");
        String model = reader.readLine();
       DeviceStorage.deleteDevice(model);
    }

    private static void findAll() {
        System.out.println("Find all device");
        Device[] device = DeviceStorage.getDevice();
        System.out.println("products = " + Arrays.toString(device));
    }

    private static void exit() {
        System.exit(0);

    }
}
