package ua.com.alevel;

import ua.com.alevel.controller.DeviceShopController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new DeviceShopController().start();
    }
}