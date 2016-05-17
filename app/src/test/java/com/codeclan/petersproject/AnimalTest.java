package com.codeclan.petersproject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by user on 29/04/2016.
 */
public class AnimalTest {
    @Test
    public void testAnimalSpecies(){
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        assertEquals(a.mSpecies, "Dog");
    }

    @Test
    public void testDefaultAnimalHunger() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        assertEquals(a.getHunger(), 100);
    }

    @Test
    public void testAnimalExoticRating(){
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        assertEquals(a.mExoticness, 30);
    }

    @Test
    public void testAnimalCanGetHungry() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        a.increaseHunger(50);
        assertEquals(50, a.getHunger());
    }

    @Test
    public void testAnimalCanBeFed() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        a.increaseHunger(50);
        a.feedAnimal(10);
        assertEquals(60, a.getHunger());
    }

    @Test
    public void testAnimalCantOverfeed() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        a.feedAnimal(3000);
        assertEquals(100, a.getHunger());
    }

    @Test
    public void testCantGetTooHungry() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        a.increaseHunger(300000);
        assertEquals(0, a.getHunger());
    }

    @Test
    public void testAnimalRampageBehavior() {
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        String testRampage = a.mRampage.testEngage();
        assertEquals( "engage", testRampage );
    }


}
