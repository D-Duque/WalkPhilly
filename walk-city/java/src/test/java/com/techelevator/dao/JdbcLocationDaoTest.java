package com.techelevator.dao;

import com.techelevator.model.Location;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcLocationDaoTest
{
    private JdbcLocationDao locationDao;

    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        locationDao = new JdbcLocationDao(jdbcTemplate);

        List<Location> locationList = new ArrayList<>();
        Location locationOne = new Location() {{
            setLocationId(100);
            setLocationName("Liberty Bell");
            setCategory("Historical");
            setLatitude(39.9496);
            setLongitude(-75.1503);
            setAddress("526 Market St, Philadelphia, PA 19106");
            setDescription("This is a test description of the liberty bell.");
            setAvailability("All the time if you're brave enough");
            setImage("testurl.png");
            setSocialMedia("None");
        }};
        Location locationTwo = new Location() {{
            setLocationId(101);
            setLocationName("Test Location");
            setCategory("Test Category");
            setLatitude(21.1111);
            setLongitude(-11.2222);
            setAddress("Test Address");
            setDescription("This is a test description of the Test Location.");
            setAvailability("Test availability");
            setImage("testurl.png");
            setSocialMedia("None");
        }};

        locationList.add(locationOne);
        locationList.add(locationTwo);
    }
    @Test
    public void findAll_ShouldReturnAListOfAllLocations()
    {
        //arrange
        int expected = 10;
        //act
        int actual = locationDao.findAll().size();
        //assert
        String msg = "Because the list of locations should total 10";
        assertEquals(msg, expected, actual);
    }

    @Test
    public void getLocationById_ShouldReturnALocationById()
    {
        //arrange
        
        //act

        //assert
    }

    @Test
    public void findByName_ShouldReturnALocationByName()
    {
    }

    @After
    public void tearDown() throws Exception
    {
        // delete added test item
    }
}
