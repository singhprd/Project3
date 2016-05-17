package com.codeclan.petersproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 29/04/2016.
 */
public class Enclosure implements Serializable {
    private int mId;
    public int mCapacity;
    ArrayList<Animal> mAnimals;
    public int mCost;
    public String mName;

    public Enclosure(int capacity) {
        mCapacity = capacity;
        mAnimals = new ArrayList<Animal>();
    }

    public void setName(String name){
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public static int calculateCostOfEnclosure(int capacity) {
        int toReturn = 0;
        toReturn = (capacity * capacity)* 10;
        return toReturn;
    }

    public int countAnimals() {
        return mAnimals.size();
    }

    public void addToEnclosure(Animal animal) {
        mAnimals.add(animal);
    }

    public int totalExoticness() {
        int totalExoticness = 0;
        for (Animal animal : mAnimals) {
            totalExoticness += animal.mExoticness;
        }
        return totalExoticness;
    }

    public void setId(int n) {
        mId = n;
    }

    public int getId() {
        return mId;
    }
}
