package com.codeclan.petersproject;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by user on 29/04/2016.
 */
public class EnclosureTest {

    @Test
    public void TestEnclosureCapacity() {
        Enclosure e = new Enclosure(2);
        assertEquals(e.mCapacity, 2);
    }

    @Test
    public void TestEnclosureCanAddAnimal() {
        Enclosure e = new Enclosure(2);
        Animal a = new Animal("Tiger", 40, new testRampageBehavior());
        e.addToEnclosure(a);
        assertEquals(e.countAnimals(), 1);
    }

    @Test
    public void TestEnclosureTotalExoticness() {
        Enclosure e = new Enclosure(2);
        Animal a = new Animal("Dog", 30, new testRampageBehavior());
        Animal a2 = new Animal("Dog", 30, new testRampageBehavior());
        e.addToEnclosure(a);
        e.addToEnclosure(a2);
        assertEquals(e.totalExoticness(), 60);
    }

    @Test
    public void TestEnclosureCanCalculateCost() {
        int a = Enclosure.calculateCostOfEnclosure(1);
        assertEquals(10, a);
    }

    @Test
    public void TestEnclosureCanCalculateCost2() {
        int a = Enclosure.calculateCostOfEnclosure(2);
        assertEquals(40, a);
    }

    @Test
    public void TestEnclosureCanCalculateCost3() {
        int a = Enclosure.calculateCostOfEnclosure(3);
        assertEquals(90, a);
    }


}
