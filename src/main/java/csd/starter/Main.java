package csd.starter;

import java.io.InputStream;
import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        System.out.println("Enter your time: ");
        e2e(System.in);
    }

    public static void e2e(InputStream in) {
        Scanner scanner = new Scanner(in);
        String time = scanner.nextLine();
        System.out.println(Feerate.fee(Integer.valueOf(time)));
    }


}
