package searchAndSort;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ObjectALBinarySearchRecursive
{
   // perform a binary search on the data  

    public static <T extends Comparable<T>> int recursiveBinarySearch(List<T> sortedArray, int start, int end, T key) {
         
        if (start < end) {
            int mid = start + (end - start) / 2;  
            if (key.compareTo( sortedArray.get(mid))>0) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key.compareTo( sortedArray.get(mid))<0) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;   
            }
        }
        return -(start + 1);  
    }
    
    /*public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       SecureRandom generator = new SecureRandom();

       int[] data = new int[15]; // create array

       for (int i = 0; i < data.length; i++) // populate array
          data[i] = 10 + generator.nextInt(90);

       Arrays.sort(data); // binarySearch requires sorted array
       System.out.printf("%s%n%n", Arrays.toString(data)); // display array

       // get input from user
       System.out.print("Please enter an integer value (-1 to quit): ");
       int searchInt = input.nextInt(); 

       // repeatedly input an integer; -1 terminates the program
       while (searchInt != -1)
       {
          // perform search
          int location = recursiveBinarySearch(data,0,data.length, searchInt);

          if (location <0) // not found
             System.out.printf("%d was not found%n%n", searchInt); 
          else // found
             System.out.printf("%d was found in position %d%n%n", 
                searchInt, location);

          // get input from user
          System.out.print("Please enter an integer value (-1 to quit): ");
          searchInt = input.nextInt();
       } 
    } // end main*/
    
   
}