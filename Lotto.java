package Midterm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Lotto game!");

        // Prompt user to enter the number of lines they want to play
        System.out.print("How many lines do you want to play? ");
        int numOfLines = scanner.nextInt();

        // Set the range of numbers that can be chosen
        int minNum = 1;
        int maxNum = 49;
        int numOfNumbers = 6;

        // Generate a random winning ticket
        ArrayList<Integer> winningTicket = generateRandomTicket(minNum, maxNum, numOfNumbers);

        // Loop through each line and generate random numbers for the user's ticket
        for (int i = 1; i <= numOfLines; i++) {
            ArrayList<Integer> userTicket = generateRandomTicket(minNum, maxNum, numOfNumbers);

            // Print the numbers for the user's ticket
            System.out.print("Line " + i + ": ");
            for (int num : userTicket) {
                System.out.print(num + " ");
            }

            // Check if the user's ticket is a winning ticket
            int numOfMatches = countMatches(userTicket, winningTicket);
            if (numOfMatches == numOfNumbers) {
                System.out.println(" - JACKPOT!");
            } else {
                System.out.println(" - " + numOfMatches + " match(es)");
            }
        }

        // Print the winning ticket
        System.out.print("\nWinning ticket: ");
        for (int num : winningTicket) {
            System.out.print(num + " ");
        }

        // Close the scanner
        scanner.close();
    }

    // Method that generates a random ticket
    public static ArrayList<Integer> generateRandomTicket(int minNum, int maxNum, int numOfNumbers) {
        ArrayList<Integer> ticket = new ArrayList<>();

        // Generate random numbers
        while (ticket.size() < numOfNumbers) {
            int randomNum = new Random().nextInt((maxNum - minNum) + 1) + minNum;

            // Check if the number has already been chosen
            if (!ticket.contains(randomNum)) {
                ticket.add(randomNum);
            }
        }

        // Sort the numbers in ascending order
        Collections.sort(ticket);

        return ticket;
    }

    // Method that counts the number of matches between two tickets
    public static int countMatches(ArrayList<Integer> ticket1, ArrayList<Integer> ticket2) {
        int count = 0;

        for (int num : ticket1) {
            if (ticket2.contains(num)) {
                count++;
            }
        }

        return count;
    }

}