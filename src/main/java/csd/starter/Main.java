package csd.starter;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	private Main() {

	}

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		user.session.setScan(scan);
		user.onLine();

		scan.close();
	}

}
