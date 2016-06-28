package com.example.java;

import com.example.java.Queue;

import java.util.Arrays;

/*******************************************************************************
     * QueueArray Class
     *
     * Array that holds the elements in queue and throws QueueOverflowException if enqueue is attempted on a full queue and QueueUnderflowException if dequeue is attempted on an empty queue.
     *
     * Preconditions: The party must arrive at the restaurant.
     * Postconditions:
     *
     * @author Anabetsy Rivero
     * created on June 26, 2016
     * @version 1.0
     *
     ******************************************************************************/


    public class QueueArray<T> implements Queue<T>
    {
        Object[] queue;
        protected int numElements = 0;
        protected int front = 0;
        protected int rear = 0;

        public QueueArray(int maxsize)
        {
            queue = (T[]) new Object [maxsize];
        }



        // Transformers/Mutators
        @Override
        public void enqueue(Party p) {
            //Throws QueueOverflowException if this queue is full;
            //otherwise,adds party to the rear of this queue
            if (isFull())
                throw new QueueOverflowException("Enqueue attempted on a full queue. ");
            else {

                queue[rear] = p;
                rear = (rear + 1) % queue.length;
                numElements = numElements + 1;
            }

        }


        public T dequeue()
        //Throws QueueUnderflowException if this queue is empty;
        //otherwise, removes party from the front of this queue and returns party.
        {
            if ( isEmpty())
                throw new QueueUnderflowException( "Dequeue attempted on an empty queue.");
            else{
                T toReturn = (T) queue[front];
                queue[front] = null;
                front = ( front + 1) % queue.length;
                numElements = numElements - 1;
                return toReturn;

            }

        }

        //Sets queue to empty state
        public void makeEmpty()
        {
            numElements = 0;
            front = 0;
            rear = 0;
        }

        // Observers/Accessors
        public Object getFront()
        {
            if( isEmpty( ) )
                return null;
            return queue[front];
        }

        //Returns the size of the queue
        public int size() {
            return numElements;
            }

        //Returns true if this queue is empty; otherwise, returns false.
        public boolean isEmpty()
            {
                return ( numElements == 0);
                 }

        //Returns true if this queue is full; otherwise, returns false
        public boolean isFull()
            {
                    return (numElements == queue.length);
                 }
        @Override
        public String toString() {
            String notSeated = " ";

            //returns parties that were never seated
            for(int i = 0 ;i < queue.length ; i++) {
                if (queue[i] != null)
                    notSeated = notSeated + queue[i]+", ";
            }
            return notSeated;

        }


    }




