package searchAndSort;
//  LinearSearch.java
// Sequentially searching an array for an item.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ObjectALLinearSearch
{
        
    
   // perform a linear search on the data              
   public static <T extends Comparable<T>> int linearSearch(List<T> data, T searchKey)       
   {                                                   
      // loop through array sequentially               
      for (int index = 0; index < data.size(); index++)
         if (data.get(index).compareTo(searchKey) == 0)                 
            return index; // return index of integer   

      return -1; // integer was not found
   } // end method linearSearch          

   /*public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      int[] data = new int[10]; // create array

      for (int i = 0; i < data.length; i++) // populate array
         data[i] = 10 + generator.nextInt(90);

      System.out.printf("%s%n%n", Arrays.toString(data)); // display array

      // get input from user
      System.out.print("Please enter an integer value (-1 to quit): ");
      int searchInt = input.nextInt(); 

      // repeatedly input an integer; -1 terminates the program
      while (searchInt != -1)
      {
         int position = linearSearch(data, searchInt); // perform search

         if (position == -1) // not found
            System.out.printf("%d was not found%n%n", searchInt); 
         else // found
            System.out.printf("%d was found in position %d%n%n", 
               searchInt, position);

         // get input from user
         System.out.print("Please enter an integer value (-1 to quit): ");
         searchInt = input.nextInt();
      } 
   } // end main*/
} // end class LinearSearch

