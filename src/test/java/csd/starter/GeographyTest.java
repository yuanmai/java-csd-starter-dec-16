package csd.starter;

import csd.starter.vo.Court;
import org.junit.Assert;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;

import csd.starter.vo.Geography;
import csd.starter.vo.Location;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GeographyTest {

    Court c1 = new Court(1);

    @BeforeClass
    public void add_one_count_size_should_be_one(){
        Location location_1 = new Location(1,2);
        c1.setLocation(location_1);
    }


    @Test
    public void same_site_should_return_itself() {

    	Location location_1 = new Location(1,2);
        assertEquals(1,Geography.lookup(location_1 , Arrays.asList(c1)).getCountId());
//        Location location_2 = new Location(10,20);
//        assertEquals(2,Geography.lookup(location_2).getId());
//        Location location_3 = new Location(30,2);
//        assertEquals(3,Geography.lookup(location_3).getId());
//        Location location_4 = new Location(110,299);
//        assertEquals(4,Geography.lookup(location_4).getId());
    }
    
    @Test
    public void find_nearest_site() {

    	Location location_1 = new Location(1,3);
        assertEquals(1,Geography.lookup(location_1 , Arrays.asList(c1)).getCountId());
//        Location location_2 = new Location(10,25);
//        assertEquals(9,Geography.lookup(location_2).getId());
//        Location location_3 = new Location(30,9);
//        assertEquals(3,Geography.lookup(location_3).getId());
//        Location location_4 = new Location(110,279);
//        assertEquals(4,Geography.lookup(location_4).getId());
    }
    
    @Test
    public void user_can_input_location(){
//    	Tennis tennis = Geography.userSearchTennnis();
//    	assertEquals(1,tennis.getId());
    }
	
	
//
//	@Before
//	public void init(){
//		Tennis.getTennisAssembly().add(new Tennis(1,new Location(1,2)));
//		Tennis.getTennisAssembly().add(new Tennis(2,new Location(10,20)));
//		Tennis.getTennisAssembly().add(new Tennis(3,new Location(30,2)));
//		Tennis.getTennisAssembly().add(new Tennis(4,new Location(110,299)));
//		Tennis.getTennisAssembly().add(new Tennis(5,new Location(20,13)));
//		Tennis.getTennisAssembly().add(new Tennis(6,new Location(50,299)));
//		Tennis.getTennisAssembly().add(new Tennis(7,new Location(80,20)));
//		Tennis.getTennisAssembly().add(new Tennis(8,new Location(12,20)));
//		Tennis.getTennisAssembly().add(new Tennis(9,new Location(13,24)));
//		Tennis.getTennisAssembly().add(new Tennis(10,new Location(11,28)));
//
//	}

}
