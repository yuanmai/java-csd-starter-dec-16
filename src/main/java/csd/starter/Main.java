package csd.starter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import csd.starter.vo.Court;
import csd.starter.vo.Player;
public class Main {
	private Main(){}
    
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

    	String[] inputs=getInput();
    	Player p1 = new Player(inputs[0]);
    	Date bookDate = dateFormat.parse(inputs[1]);
		Court c1 = new Court(Integer.valueOf(inputs[3]));

        TennisReservation.makeReservation(bookDate, Integer.valueOf(inputs[2]), p1,c1);

    }
    


	public static void scanner(Scanner s) {
        s.close();
	}

	public static String[] getInput(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		String[] inputArray=input.split(",");
		return inputArray;
	}
	public static ByteArrayOutputStream setOutPut(){	
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		return output;
	}
    
}
