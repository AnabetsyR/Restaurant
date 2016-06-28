package com.example.java;
/*******************************************************************************
 * Driver Main Class
 *
 * Class that acts as the Main class of the application. It contains prompts to obtain the name of the data file and processes the file line by line. For lines starting with the character 'A', it places the party in the queue. For lines starting with the character 'T', it dequeues the party from the front of the queue and prints the necessary information. For the line starting with the character 'Q', the program stops and prints the final lines of output.
 *
 * Preconditions:The data.txt file must exist and contain information about the parties. Lines in the file must either start with an 'A', a 'T', or a 'Q'.
 * Postconditions:Tells the party of 'name' of 'x' people to wait at the bar. Once a table is available, it tells the party that a table for 'name' of 'x' people is available. After processing all the parties, it calculates the average waiting time and tells the user which parties were never seated.
 *
 * @author Anabetsy Rivero
 * created on June 20, 2016
 * @version 1.0
 *
 ******************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        int numSeated = 0;
        //size of party?
        int sSize = 0;
        //total time= sum of wait times for all parties. This is used for the average waiting time
        double totTime = 0;


        System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
        //Get the name of the file from the user
        System.out.println("Please, enter the name of the data file: ");


        // Create new Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        //System.out.println(fileName);
        Scanner fileToRead = new Scanner(new File(fileName));


        QueueArray Q = new QueueArray(10);

        //Sets the condition for reading the first character of each line in file.
        boolean flag = true;

        int sittingTime = 0;
        int arrivalTime = 0;
        while ( fileToRead.hasNext() ) {
            String[] line = fileToRead.nextLine().split(" ");
            for (int i = 4; i < line.length; i++)
                line[3] += " " + line[i];

            char action = line[0].charAt(0);

            //if line starts with 'A', enqueue party
            if (action == 'A') {

                Party p = new Party(line[3], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                Q.enqueue(p);

                System.out.println("Please wait at the bar, party " + p.getName() + " of " + p.getSize() +
                        " people." + "(time = " + p.getTime() + ")" + "\n");
            }


            //if line starts with 'T', dequeue party from front
            else if (action == 'T') {

                tTime = Integer.parseInt(line[1]);
                Party p = (Party) Q.dequeue();
                waitTime += (tTime - p.getTime())*p.getSize();
                numSeated += p.getSize();

                //Prints when a table becomes available for a party
                System.out.println("Table for party " + p.getName() + " of " +
                        p.getSize() + "!" + "(time = " + p.getTime() + ")" + "\n");


            }


            // if line starts with 'Q' stop the simulation
            else if (action == 'Q') {
                break;
            }
        }


        //Prints parties that were never seated(remain in queue).
        if (!Q.isEmpty()) {
            //for (int i = 0; i < Q.size(); i++) {
                System.out.println("The following parties were never seated:" + Q);
        }

        //Calculates the average waiting time per guest
        double avg = Math.round(waitTime*1.0/numSeated*100)/100d;

        //Prints the average waiting time in minutes.
        System.out.println("The average waiting time was: "+avg+" minutes");
        System.out.println("***Simulation Terminated***");
        System.out.println("Good bye! ");
    }
}
































