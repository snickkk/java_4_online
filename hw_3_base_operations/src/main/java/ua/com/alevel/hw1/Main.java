package ua.com.alevel.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum;
        System.out.println("Enter the string");
        while (!(line = reader.readLine()).equals("exit")) {
            sum = 0;
            Pattern pattern = Pattern.compile("[!\\d]*(\\d+)[!\\d]*");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
            System.out.println("Your sum is = " + sum + ". Write \"exit\" to exit the program");

        }
    }
}