package csd.starter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import csd.starter.vo.Count;
import csd.starter.vo.Player;
public class Main {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

    public static void main(String[] args) throws ParseException {
    	String[] inputs=getInput();
    	Player p1 = new Player(inputs[0]);
    	Date bookDate = dateFormat.parse(inputs[1]);
		Count c1 = new Count(Integer.valueOf(inputs[3]));
	    ByteArrayOutputStream result=setOutPut();
        TennisReservation.makeReservation(bookDate, Integer.valueOf(inputs[2]), p1,c1);
        checkResult(result);
    }
    
	private static void checkResult(ByteArrayOutputStream result) {
		assertEquals("success",result.toString());	
	}

	public static void scanner(Scanner s) {
		int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(x);
        System.out.println(y);
        s.close();
	}

	public static String[] getInput(){
		System.out.println("Enter your book information(user,time,hour,court): ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("your book information:"+input);
		String[] inputArray=input.split(",");
		return inputArray;
	}
	public static ByteArrayOutputStream setOutPut(){	
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		return output;
	}
    
}
