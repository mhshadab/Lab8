package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){ list = new CustomList(null,new ArrayList<>()); return list; }

    /**
     * get the size of the list * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test public void addCityTest()
    { list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1); }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);

        assertEquals(1, list.hasCity(city));

    }
    @Test
    void testHasCityFail() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");


        assertEquals(0, list.hasCity(city));

    }

    @Test
    void testDelete() {
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(listSize+1, list.getCount());
        list.delete(city);
        assertEquals(listSize, list.getCount());
        assertEquals(0,list.hasCity(city));
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        int listSize = list.getCount();
        assertEquals(listSize, list.countCities());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(listSize+1, list.countCities());

    }




}
