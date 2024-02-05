package eratosthenesprofiler;

/**
 * A program to profile the Eratosthene's Sieve prime generator and compare the
 * exact value of the prime-counting function and the n/ln(n) approximation.
 *
 * @author Duncan, Bibhushita Baral
 * @see EratosthenesUtil  <pre>
 * Date: 9/4/2022
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EratosthenesProfiler {

    public static void main(String[] args) {
        long userInput;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer n to generate primes in [2,n]: ");
        userInput = in.nextLong();
        long aheadTime = System.nanoTime();
        ArrayList<Long> primeNumbers = EratosthenesUtil.sieve(userInput);
        long afterTime = System.nanoTime();
        long result = (afterTime - aheadTime)/1000 ;
        String hehe = EratosthenesUtil.toString(primeNumbers);
        System.out.println("P(" + userInput + ")= " + hehe);
        System.out.println("Time To Generate The Primes: " + result + " microseconds");
        System.out.println("pi(" + userInput + ")= " + primeNumbers.size());
        System.out.printf("%-12s %-12s %-12s %-12s %-12s \n", "n", "Time(us)", "pi(n)", "n/ln(n)", "%Error in pi(n)");
        
        for (int i = 10000; i <= 150000; i += 10000) { 
            long beforeTime = System.nanoTime();
            ArrayList<Long> primeNumTable = EratosthenesUtil.sieve(i);
            long after = System.nanoTime();
            long results = (after - beforeTime)/1000;
            long numberrr = primeNumTable.size();
            double ln = i / Math.log(i);
            double percentageError = ((ln - numberrr) / numberrr) * 100;
            System.out.printf("%-12d %-12d %-12d %-12.1f %-12.1f \n", i, results, primeNumTable.size() , i / Math.log(i), percentageError);
            
        }

    }
}
