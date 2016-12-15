package csd.starter;

import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	

    private Main() {

	}

	public static void main(String args[]) {
		 Logger log = Logger.getLogger("main"); 
         log.setLevel(Level.INFO); 
        log.info("Enter your time: ");
        e2e(System.in);
    }

    public static void e2e(InputStream in) {
    	Logger log = Logger.getLogger("main"); 
        log.setLevel(Level.INFO); 
        Scanner scanner = new Scanner(in);
        String time = scanner.nextLine();
        Integer feeAmount = Feerate.fee(Integer.valueOf(time));
        log.info(feeAmount.toString());
        
    }


}
