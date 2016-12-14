package csd.starter;

import org.junit.Before;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import csd.starter.vo.Geography;
import csd.starter.vo.Location;
import csd.starter.vo.Tennis;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GeographyTest {

//
//    @Test
//    public void Same_Site() {
//    	System.out.println("Please input location 1,2,  ");
//    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
//    	Location location = inputLocation(s); 
//        assertEquals(1,Geography.lookup(location).getId());
//    }
    @Test
    public void same_site_should_return_itself() {

    	Location location_1 = new Location(1,2);
        assertEquals(1,Geography.lookup(location_1).getId());
        Location location_2 = new Location(10,20);
        assertEquals(2,Geography.lookup(location_2).getId());
        Location location_3 = new Location(30,2);
        assertEquals(3,Geography.lookup(location_3).getId());
        Location location_4 = new Location(110,299);
        assertEquals(4,Geography.lookup(location_4).getId());
    }
    
    @Test
    public void find_nearest_site() {

    	Location location_1 = new Location(1,3);
        assertEquals(1,Geography.lookup(location_1).getId());
        Location location_2 = new Location(10,25);
        assertEquals(9,Geography.lookup(location_2).getId());
        Location location_3 = new Location(30,9);
        assertEquals(3,Geography.lookup(location_3).getId());
        Location location_4 = new Location(110,279);
        assertEquals(4,Geography.lookup(location_4).getId());
    }
    
//    @Test
//    public void Having2Nearest_Site_Should_Return_Correct_Site() {
//
//    	Location location_1 = new Location(20,21);
//        assertEquals(2,Geography.lookup(location_1).getId());
//
//    }
    
//    
//    @Test
//    public void Same_Site() {
//    	System.out.println("Please input location x,y,  ");
//    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
//    	Location location = inputLocation(s); 
//        assertEquals(1,Geography.lookup(location).getId());
//
//    }
//    @Test
//    public void testPod() {
//    	System.out.println("Please input location x,y,  ");
//    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
//    	Location location = inputLocation(s); 
//        assertEquals(1,Geography.lookup(location).getId());
//
//    }
//    @Test
//    public void testPod() {
//    	System.out.println("Please input location x,y,  ");
//    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
//    	Location location = inputLocation(s); 
//        assertEquals(1,Geography.lookup(location).getId());
//
//    }
//    
//    
    @Test
    public void user_can_input_location(){
    	Tennis tennis = Geography.userSearchTennnis();
    	assertEquals(1,tennis.getId());
    }
	
	

	@Before
	public void initial(){
		Tennis.getTennisAssembly().add(new Tennis(1,new Location(1,2)));
		Tennis.getTennisAssembly().add(new Tennis(2,new Location(10,20)));
		Tennis.getTennisAssembly().add(new Tennis(3,new Location(30,2)));
		Tennis.getTennisAssembly().add(new Tennis(4,new Location(110,299)));
		Tennis.getTennisAssembly().add(new Tennis(5,new Location(20,13)));
		Tennis.getTennisAssembly().add(new Tennis(6,new Location(50,299)));
		Tennis.getTennisAssembly().add(new Tennis(7,new Location(80,20)));
		Tennis.getTennisAssembly().add(new Tennis(8,new Location(12,20)));
		Tennis.getTennisAssembly().add(new Tennis(9,new Location(13,24)));
		Tennis.getTennisAssembly().add(new Tennis(10,new Location(11,28)));

	}

}
