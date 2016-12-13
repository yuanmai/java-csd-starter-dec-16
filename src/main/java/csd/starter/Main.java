package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(System.in).useDelimiter("\\s*fish\\s*");
        scanner(s); 
        
    }

	public static void scanner(Scanner s) {
		System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();
	}

    
}
