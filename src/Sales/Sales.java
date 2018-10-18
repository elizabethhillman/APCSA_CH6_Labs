package Sales;
/**
 * Name: Elizabeth Hillman
 * Date: 10/18/2018
 * Period: 1
 *
 * Sales.Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */
//import sun.jvm.hotspot.oops.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        // Prompt the user for the number of sales people that they need to enter
        System.out.println("How many sales people do you need to enter?");
        int people = scan.nextInt();
        // and modify the program to create an appropriately sized array.
        int[] sales = new int[people];
        
        //final int SALESPEOPLE = 5;
        //int[] sales = new int[SALESPEOPLE];
        int sum;

        for (int i=0; i < sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        //print the array for verification
        //System.out.println(Arrays.toString(sales));

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i < sales.length; i++)
        {
            System.out.println("\t " + i + "\t\t\t" + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);


        //Use your average method to print the average sales
        System.out.println("The average of the numbers in the array is " + average(sales));

        // Use your indexOfMax method to print the index of the best sales person
        System.out.println("The person with the highest sales is Salesperson: #" + indexOfMax(sales));
        // and the sales amount for that sales person.
        System.out.println("They sold " + sales[indexOfMax(sales)] + " units.");


        // Do the same for the worst sales person
        System.out.println("The person with the lowest sales is Salesperson: #" + indexOfMin(sales));
        System.out.println("They sold " + sales[indexOfMin(sales)] + " units.");

    }

    public static double average(int[] arr) throws IllegalStateException {
        double add = 0.0;

        //  compute and return the average of arr
        //Be sure to use the length instance variable and you may assume that the array is full.
        //If the array does not have at least 1 element in it, throw an IllegalStateException
        if (arr.length == 0) {
            throw new IllegalStateException();
        } else {
            for (int x = 0; x < arr.length; x++) {
                add += arr[x];
            }
            return add / arr.length;
        }
    }




    public static int indexOfMax(int[] arr)
    {

        // find and return the index of the max value in arr
        int max = Integer.MIN_VALUE;
        int maxLocation = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(max < arr[i]){
                max = arr[i];
                maxLocation = i;
            }
        }

        return maxLocation;
    }

    // Do the same for an indexOfMin method
    public static int indexOfMin(int[] arr)
    {

        // find and return the index of the max value in arr
        int min = Integer.MAX_VALUE;
        int minLocation = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(min > arr[i]){
                min = arr[i];
                minLocation = i;
            }
        }

        return minLocation;
    }

}
