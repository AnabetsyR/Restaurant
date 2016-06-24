package com.example.java;
/*******************************************************************************
 * Driver Main Class
 *
 * Class that acts as the Main class of the application. It contains prompts to obtain the name of the data file and processes the file line by line. For lines starting with the character 'A', it places the party in the queue. For lines starting with the character 'T', it dequeues the party from the front of the queue and prints the necessary information. For the line starting with the character 'Q', the program stops and prints the final lines of output.
 *
 * Preconditions:The data.txt file must exist and contain information about the parties. Lines in the file must either start with an 'A', a 'T', or a 'Q'.
 * Postconditions:Tells the party of 'name' of 'x' people to wait at the bar. Once a table is available, it tells the party that a table for 'name' of 'x' people is available. After processing all the parties, it calculates the average waiting time and tells the user which parties were never seated.
 *
 * @author Student Name
 * @date Date
 * @version 1.0
 *
 ******************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {


    public static void main(String[] args) throws IOException {

        //size of queue
        int qSize = 4;
        //time party arrives
        int aTime = 0;
        //time table becomes available
        int tTime = 0;
        //time the party waits to be seated = time table becomes available - time party arrives
        int waitTime = 0;
        //size of party?
        int sSize = 0;
        //total time= sum of wait times for all parties. This is used for the average waiting time
        double totTime = 0;


        System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
        //Get the name of the file from the user
        System.out.println("Please, enter the name of the data file: ");


        BufferedReader in = new BufferedReader(new FileReader("data.txt"));
        // Create new Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        //System.out.println(fileName);
        Scanner fileToRead = new Scanner(new File(fileName));


        QueueArray Q = new QueueArray(4);

        boolean flag = true;

        int sittingTime = 0;
        int arrivalTime = 0;
        while (flag == true) {
            char action = fileToRead.next().charAt(0);
            {


                //if line starts with 'A', enqueue party
                if (action == 'A') {

                    Party p = new Party();
                    arrivalTime = fileToRead.nextInt();
                    sSize = fileToRead.nextInt();
                    String name = fileToRead.nextLine();

                    p.name = name;
                    Q.enqueue(p);


                    System.out.println("Please wait at the bar, party " + name + " of " + sSize + " people." + "(time = " + arrivalTime + ")" + "\n");
                }


                //if line starts with 'T', dequeue party from front
                if (action == 'T') {

                    tTime = fileToRead.nextInt();
                    Party p = (Party) Q.dequeue();


                    //Prints when a table becomes available for a party
                    System.out.println("Table for party" + p.toString() + " of " + sSize + "!" + "(time = " + tTime + ")" + "\n");

                    //Needs to print correct totTime
                    //totTime = totTime + sSize*(tTime - arrivalTime);
                    //System.out.println(totTime);
                }


            }

            // if line starts with 'Q' stop the simulation
            if (action == 'Q') {
                flag = false;
            }
        }
        //For this calculation a for loop may be necessary.This needs to get fixed so it prints the correct waitTime.
        //for (int i = 0; i < Q.size(); i++) {
        //waitTime = sittingTime - arrivalTime;
        //System.out.println(waitTime);
        // }


        //Parties that remain in queue should be printed below.

        if (!Q.isEmpty()) {
            //for (int i = 0; i < Q.size(); i++) {
                System.out.println("The following parties were never seated:" + Q.toString());
                }

                //Still need to get program to do the math and output waitTime. Not too hard!
                System.out.println("The average waiting time was: ");
                System.out.println("***Simulation Terminated***");
                System.out.println("Good bye! ");
            }
        }
































