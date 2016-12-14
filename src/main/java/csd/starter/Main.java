package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//      String input = "10,10";
    	System.out.println("Please input location x,y,  ");
    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
    	scanner(s); 
        
    }

	public static void scanner(Scanner s) {
		int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(x);
        System.out.println(y);
        s.close();
	}

    
}
