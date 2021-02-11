package searchAndSort;
// : InsertionSort.java
// Sorting an array with insertion sort.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class ObjectALInsertionSort
{
   // sort array using insertion sort
   public static <T extends Comparable<T>> void insertionSort(List<T> data)                
   {
      // loop over data.length - 1 elements           
      for (int next = 1; next < data.size(); next++)
      {
         T insert = data.get(next); // value to insert
         int moveItem = next; // location to place element

         // search for place to put current element             
         while (moveItem > 0 && data.get(moveItem-1).compareTo(insert)<0)
         {
            // shift element right one slot         
            data.set(moveItem, data.get(moveItem-1));
            moveItem--;                             
         } 

         data.set(moveItem, insert); // place inserted element    
         //printPass(data, next, moveItem); // output pass of algorithm
      }                                             
   }

   // print a pass of the algorithm
   public static <T extends Comparable<T>> void printPass(List<T> data, int pass, int index)
   {
      System.out.printf("after pass %2d: ", pass);

      // output elements till swapped item
      for (int i = 0; i < index; i++)
         System.out.printf("  ", data.get(i).toString());

      System.out.printf("  ", data.get(index).toString()); // indicate swap

      // finish outputting array
      for (int i = index + 1; i < data.size(); i++)
         System.out.printf("  ", data.get(i).toString());

      System.out.printf("%n               "); // for alignment

      // indicate amount of array that�s sorted
      for(int i = 0; i <= pass; i++)
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
      insertionSort(data); // sort array

      System.out.printf("Sorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
   } */
} // end class InsertionSort

