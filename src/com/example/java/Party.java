/*******************************************************************************
 * Party Class
 *
 * The party class stores the information of each party that arrives at the restaurant.
 * Preconditions: There must be a party that arrives at the restaurant. The party must have a name, a size, and arrival time.
 * Postconditions: Stores the party name, size, and arrival time.
 *
 * @author Anabetsy Rivero
 * created on June 26, 2016
 * @version 1.0
 *
 ******************************************************************************/
package com.example.java;

public class Party {

    public String name;
    public int arrivalTime;
    public int size;

    public Party(String n, int t, int s){
        name= n;
        arrivalTime = t;
        size = s;
    }

    // Method for accessing the arrival time of the party.
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getTime() {
        return arrivalTime;
    }

    //Method for accessing the name of the object.
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName()+":"+getSize()+" ";
    }

     //Method for accessing the size of the object.
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
