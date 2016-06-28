package com.example.java;
/*******************************************************************************
 * Queue Interface
 *
 * The Queue interface is an interface that contains the transformer, and observer methods.
 *
 * Preconditions: There must be a party
 * Postconditions: Provides the transformer and observer methods for the QueueArray
 *
 * @author Anabetsy Rivero
 * created on June 20, 2016
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

