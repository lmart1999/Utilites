package searchAndSort;
//  SelectionSort.java
// Sorting an array with selection sort.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class ObjectALSelectionSort
{
   // sort array using selection sort
   public static <T extends Comparable<T>> void selectionSort(List<T> data)              
   {
      // loop over data.length - 1 elements      
      for (int i = 0; i < data.size() - 1; i++)
      {
         int smallest = i; // first index of remaining array

         // loop to find index of smallest element              
         for (int index = i + 1; index < data.size(); index++)
            if (data.get(index).compareTo(data.get(smallest))>0)             
               smallest = index;                                

         swap(data, i, smallest); // swap smallest element into position
        // printPass(data, i + 1, smallest); // output pass of algorithm  
      }                                          
   } // end method selectionSort                                    

   // helper method to swap values in two elements
   private static <T extends Comparable<T>> void swap(List<T> data, int first, int second)
   {
      T temporary = data.get(first); // store first in temporary
      data.set(first, data.get(second)); // replace first with second
      data.set(second, temporary); // put temporary in second
   } 

   // print a pass of the algorithm
   private static <T extends Comparable<T>> void printPass(List<T> data, int pass, int index)
   {
      System.out.printf("after pass %2d: ", pass);

      // output elements till selected item
      for (int i = 0; i < index; i++)
         System.out.printf("  ", data.get(i).toString());

      System.out.printf(" ", data.get(index).toString()); // indicate swap

      // finish outputting array
      for (int i = index + 1; i < data.size(); i++)
         System.out.printf("  ", data.get(i).toString());

      //System.out.printf("%n               "); // for alignment

      // indicate amount of array that�s sorted
      for (int j = 0; j < pass; j++)
         System.out.print("--  ");
      System.out.println(); 
   } 

   /*public static void main(String[] args)
   {
      SecureRandom generator = new SecureRandom();

      int[] data = new int[10]; // create array

      for (int i = 0; i < data.length; i++) // populate array
         data[i] = 10 + generator.nextInt(90);

      System.out.printf("Unsorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
      selectionSort(data); // sort array

      System.out.printf("Sorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
   } */
} // end class SelectionSort



