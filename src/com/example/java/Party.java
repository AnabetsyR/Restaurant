/*******************************************************************************
 * Party Class
 *
 * Description here….
 *
 * Preconditions:
 * Postconditions:
 *
 * @author Student Name
 * @date Date
 * @version 1.0
 *
 ******************************************************************************/
package com.example.java;

public class Party {

    public String name;
    public int arrivalTime;
    public int size;

    /**
     * Method for accessing the arrival time of the party.
     *
     * @return int time
     *
     */

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getTime() {
        return arrivalTime;
    }

    /**
     * Method for accessing the name of the object.
     *
     * @return String name
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * Method for accessing the size of the object.
     *
     * @return int size
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
