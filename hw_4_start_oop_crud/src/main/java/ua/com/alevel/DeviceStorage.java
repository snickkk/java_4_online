package ua.com.alevel;

public class DeviceStorage {


        public  static int count = 0;
        private static Device[] devices = new Device[1];

    private static void DeviceArray() {
        Device[] newDevices= new Device[devices.length + 1];
        for (int i = 0; i < devices.length; i++) {
            newDevices[i] = devices[i];
        }
        devices = newDevices;
    }

        private  DeviceStorage() {}

        public static Device[] getDevice() {
            return devices;
        }

        public static void addDevice(Device device) {
            for (int i = 0; i < devices.length; i++) {
                if (count == devices.length) {
                    DeviceArray();
                } else {
                    devices[count] = device;
                    count++;
                    break;

                }
            }

        }

        public static void deleteDevice(String model) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getBrand().equals(model)) {
                        devices[i] = null;
                        return;
                    }
                }
            }
            System.out.println("Wrong model");
        }

        public static Device getModel(String model) {
            for (Device device : devices) {
                if (device != null) {
                    if (device.getBrand().equals(model)) {
                        return device;
                    }
                }
            }
            return null;
        }
}
