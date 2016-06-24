package com.example.java;

/*******************************************************************************
     * QueueArray Class
     *
     * Array that holds the elements in queue and throws QueueOverflowException if enqueue is attempted on a full queue and QueueUnderflowException if dequeue is attempted on an empty queue.
     *
     * Preconditions:
     * Postconditions:
     *
     * @author Anabetsy Rivero
     * @date June 22, 2016
     * @version 1.0
     *
     ******************************************************************************/

    public class QueueArray<T> implements Queue<T>
    {
        Object[] queue;
        protected int numElements = 0;
        protected int front = 0;
        protected int rear = -1;

        public QueueArray(int maxsize)
        {
         queue = (T[]) new Object [maxsize];
            rear = maxsize - 1;
        }



        // Transformers/Mutators
        @Override
        public void enqueue(Party p) {
            //Throws QueueOverflowException if this queue is full;
            //otherwise,adds x to the rear of this queue
            {
                if (isFull())
                    throw new QueueOverflowException("Enqueue attempted on a full queue. ");
                else {
                    rear = (rear + 1) % queue.length;
                    queue[rear] = p;
                    numElements = numElements + 1;
                }
            }
        }


        public T dequeue()
        //Throws QueueUnderflowException if this queue is empty;
        //otherwise, removes x from the front of this queue and returns x.
        {
            if ( isEmpty())
                throw new QueueUnderflowException( "Dequeue attempted on an empty queue.");
                else{
                T toReturn = (T) queue[front];
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
                rear = -1;
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
            return rear;
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
            String notSeated = "";

            //returns parties that were never seated
            for(int i = 0 ;i <= numElements - 1; i++) {
                notSeated = notSeated + queue[i]+"\n";
            }
            return notSeated;
        }


    }




