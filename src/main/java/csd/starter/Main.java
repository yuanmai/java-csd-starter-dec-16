package csd.starter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		User user = new User();
		user.session.setScan(scan);
		user.onLine();
		
		scan.close();
	}

}
