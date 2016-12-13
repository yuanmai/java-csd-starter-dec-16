package csd.starter;

import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        System.out.println("Enter your time: ");
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        System.out.println("Your fee is " + Feerate.fee(Integer.valueOf(time)));
    }



}
