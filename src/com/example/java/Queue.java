package com.example.java;
/*******************************************************************************
 * Queue Interface
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

public interface Queue<T> {


    // Transformers/Mutators
    public void enqueue(Party p);
    public T dequeue();
    //return ;
    public void makeEmpty();

    // Observers/Accessors
    public Object getFront();
    public int size();
    public boolean isEmpty();
    public boolean isFull();


}

