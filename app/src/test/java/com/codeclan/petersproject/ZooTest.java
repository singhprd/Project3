package com.codeclan.petersproject;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 29/04/2016.
 */
public class ZooTest {
    @Test
    public void TestZooCanSetAndGetName() {
        Zoo z = new Zoo();
        z.setName("Peters Zoo");
        assertEquals("Peters Zoo", z.getName());
    }

    @Test
    public void TestZooHasMoney() {
        Zoo myZoo = new Zoo();
        assertEquals(myZoo.getCurrentBalance(), 1000);
    }

    @Test
    public void TestGetMoney() {
        Zoo z = new Zoo();
        assertEquals(1000, z.getCurrentBalance());
    }

    @Test
    public void TestZooHasVisitorCapacity() {
        Zoo myZoo = new Zoo();
        assertEquals(myZoo.getVisitorCapacity(), 10);
    }

    @Test
    public void TestZooCanHaveEnclosures() {
        Zoo z = new Zoo();
        z.buyNewEnclosure(2);
        assertEquals(1, z.numberOfEnclosures());
    }

//    @Test
//    public void TestCountAllAnimals() {
//        Zoo z = new Zoo();
//        Enclosure e = new Enclosure(2);
//        z.buyNewEnclosure(2);
//        Animal a = new Animal("Lion", 60, new testRampageBehavior());
//
//        e.addToEnclosure(a);
//        Animal a2 = new Animal("Penguin", 10, new testRampageBehavior());
//        e.addToEnclosure(a2);
//        assertEquals(z.countAllAnimals(), 2);
//    }

    @Test
    public void TestAverageExoticness() {

    }

    @Test
    public void TestEndDay() {
        Zoo z = new Zoo();
        assertEquals("the day has ended", z.endDay());
    }

    @Test
    public void TestPayBill() {
        Zoo z = new Zoo();
        z.payBill(500);
        assertEquals(500, z.getCurrentBalance());
    }

    @Test
    public void TestCantPayBill() {
        Zoo z = new Zoo();
        boolean a = z.payBill(1001);
        assertFalse(a);
    }

    @Test
    public void TestCanBuyEnclosure() {
        Zoo z = new Zoo();
        z.buyNewEnclosure(2);
        assertEquals(1, z.numberOfEnclosures());
    }

    @Test
    public void TestCantBuyEnclosureIfNotEnoughDollar() {
        Zoo z = new Zoo();
        z.buyNewEnclosure(20);
        assertEquals(0, z.numberOfEnclosures());
    }

    @Test
    public void TestEnclosuresHaveIds() {
        Zoo z = new Zoo();
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        ArrayList<String> toTest = z.getEnclosuresIds();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, toTest);
    }

    @Test
    public void TestCanRemoveEnclosureById() {
        Zoo z = new Zoo();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("3");

        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        z.removeEnclosureById(1);
        ArrayList<String> result = z.getEnclosuresIds();
        assertEquals(expected, result);
    }

    @Test
    public void TestCanGetEnclosureById() {
        Zoo z = new Zoo();
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        z.buyNewEnclosure(2);
        Enclosure e = z.getEnclosureById(1);
        e.setName("Test Enclosure");
        assertEquals( "Test Enclosure" ,e.getName());
    }

    @Test
    public void TestGetArrayOfEnclosures() {
        Zoo z = new Zoo();
        Enclosure e = new Enclosure(2);
        Enclosure e2 = new Enclosure(2);
        z.addEnclosure(e);
        z.addEnclosure(e2);
        Enclosure[] expected = new Enclosure[2];
        expected[0] = e;
        expected[1] = e2;
        assertArrayEquals(expected, z.getArrayOfEnclosures());
    }

//    @Test
//    public void TestGetArrayListOfEnclosuresCapacity() {
//        Zoo z = new Zoo();
//        z.buyNewEnclosure(2);
//        z.buyNewEnclosure(2);
//        z.buyNewEnclosure(2);
//        ArrayList<String> enclosuresCapacity = z.getArrayListOfEnclosuresCapacity();
//        assertEquals(enclosuresCapacity, 1);
//    }


}
