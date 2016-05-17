package com.codeclan.petersproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 29/04/2016.
 */
public class Animal implements Serializable {
    int mHunger;
    int mExoticness;
    ArrayList<Animal> foods;
    String mSpecies;
    Rampagable mRampage;

    public int getmHealth() {
        return mHealth;
    }

    public void setmHealth(int mHealth) {
        this.mHealth = mHealth;
    }

    int mHealth;

    public Animal (String species, int exoticRating, Rampagable rampage){
        mSpecies = species;
        mExoticness = exoticRating;
        mHunger = 100;
        mRampage = rampage;
    }

    public int getHunger() {
        return mHunger;
    }

    public void feedAnimal(int i) {
        if (mHunger + i >= 100) {
            mHunger = 100;
        } else {
            mHunger += i;
        }
    }

    public void increaseHunger(int i) {
        if (mHunger - i <= 0) {
            mHunger = 0;
        } else {
            mHunger -= i;
        }
    }
}


