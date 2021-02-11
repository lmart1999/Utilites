package searchAndSort;
//  BinarySearch.java
// Use binary search to locate an item in an array.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class  ObjectALBinarySearch<T extends Comparable<T>>
{
   // perform a binary search on the data      
   public static <T extends Comparable<T>> int binarySearch(List<T> data, T key)
   {
      int low = 0; // low end of the search area                
      int high = data.size() - 1; // high end of the search area
      int middle = (low + high + 1) / 2; // middle element      
      int location = -1; // return value; -1 if not found 

      do // loop to search for element
      {
         // print remaining elements of array
         //System.out.println(remainingElements(data, low, high));

         // output spaces for alignment
         //for (int i = 0; i < middle; i++)
           // System.out.println("   ");
         //System.out.println(" * "); // indicate current middle

         // if the element is found at the middle                  
         if (key.compareTo(data.get(middle)) == 0)  {                              
            location = middle; // location is the current middle  
         }
         else if (key.compareTo(data.get(middle)) ==1) // middle element is too high
            high = middle - 1; // eliminate the higher half        
         else  // middle element is too low                        
            low = middle + 1; // eliminate the lower half          

         middle = (low + high + 1) / 2; // recalculate the middle
      } while ((low <= high) && (location == -1));               

      return location; // return location of search key
   } // end method binarySearch                        

   // method to output certain values in array
   private static <T extends Comparable<T>> String remainingElements(List<T> data, int low, int high)
   {
      StringBuilder temporary = new StringBuilder();

      // append spaces for alignment
      for (int i = 0; i < low; i++)
         temporary.append("   ");

      // append elements left in array 
      for (int i = low; i <= high; i++)
         temporary.append(data.get(i) + " \n");

      return String.format("%s%n", temporary);
   } // end method remainingElements

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
         int location = binarySearch(data, searchInt);

         if (location == -1) // not found
            System.out.printf("%d was not found%n%n", searchInt); 
         else // found
            System.out.printf("%d was found in position %d%n%n", 
               searchInt, location);

         // get input from user
         System.out.print("Please enter an integer value (-1 to quit): ");
         searchInt = input.nextInt();
      } 
   } // end main*/
} // end class BinarySearch



