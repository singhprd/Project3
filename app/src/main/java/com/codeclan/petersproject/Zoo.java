package com.codeclan.petersproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 29/04/2016.
 */
public class Zoo implements Serializable {
    private int enclosureId = 0;
    private int mVisitorCapacity;
    Zookeeper mKeeper;
    private ArrayList<Enclosure> mEnclosures;
    private int mMoney;
    public String name;

    public ArrayList<Enclosure> getEnclosures() {
        return mEnclosures;
    };

    public int getVisitorCapacity() {
        return mVisitorCapacity;
    }

    public void setVisitorCapacity(int mVisitorCapacity) {
        this.mVisitorCapacity = mVisitorCapacity;
    }

    public Zoo() {
        mVisitorCapacity = 10;
        mMoney = 1000;
        mEnclosures = new ArrayList<Enclosure>();
    }

    public int numberOfEnclosures() {
        return mEnclosures.size();
    }

    public boolean buyNewEnclosure(int capacity) {
        int cost = Enclosure.calculateCostOfEnclosure(capacity);
        if (payBill(cost)) {
            Enclosure e = new Enclosure(capacity);
            enclosureId += 1;
            e.setId(enclosureId);
            mEnclosures.add(e);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getEnclosuresIds() {
        ArrayList<String> toReturn = new ArrayList<String>();
        for (Enclosure each : mEnclosures) {
            toReturn.add( String.valueOf(each.getId()) );
        }
        return toReturn;
    }

    public boolean removeEnclosureById(int n) {
        for (Enclosure each : mEnclosures) {
            if ( each.getId() == n ) {
                int toRemove = mEnclosures.indexOf(each);
                mEnclosures.remove(toRemove);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Enclosure getEnclosureById(int n) {
        for (Enclosure each : mEnclosures) {
            if ( each.getId() == n ) {
                return each;
            }
        }
        return null;
    }

//    public ArrayList<String> getArrayListOfEnclosuresCapacity() {
//        ArrayList<String> toReturn = new ArrayList<String>();
//        for (Enclosure each : mEnclosures) {
//            String a = String.valueOf( each.mCapacity );
//            toReturn.add(a);
//        }
//        return toReturn;
//    }

    public boolean payBill(int amount) {
        if (mMoney >= amount) {
            mMoney -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int countAllAnimals() {
        int toReturn = 0;
        for (int i = 0; i < mEnclosures.size(); i++) {
            toReturn += mEnclosures.get(i).countAnimals();
        }
        return toReturn;
    }

    public int getCurrentBalance() {
        return mMoney;
    }

    public int getAverageExoticness() {
        int numberOfAnimals = this.countAllAnimals();
        System.out.println(numberOfAnimals);
        int totalExoticnessOfZoo = 0;
        for (int i = 0; i < mEnclosures.size(); i++ ) {
            totalExoticnessOfZoo += mEnclosures.get(i).totalExoticness();
        }
        System.out.println(totalExoticnessOfZoo);
        if(numberOfAnimals == 0 ) return 0;
        int toReturn = totalExoticnessOfZoo/numberOfAnimals;
        return toReturn;
    }

    public String endDay() {
        return "the day has ended";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Enclosure[] getArrayOfEnclosures() {
        Enclosure[] toReturn = new Enclosure[mEnclosures.size()];
        toReturn = mEnclosures.toArray(toReturn);
        return toReturn;
    }

    public void addEnclosure(Enclosure e) {
        mEnclosures.add(e);
    }

    //end day - Calculate income - number of visitors based on animal exotic level -
    // did new animal fit in, or get eaten?
    //hunger level decreases by 20 over night
    //an animal got too hungry and went on a rampage.... (rampage method)
}
