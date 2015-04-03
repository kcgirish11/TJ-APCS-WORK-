//name: Kiran Girish           date: 03/10/15
 /*  Assignment:  A simple hashing program is given below. Compile 
 and run.  Notice that collisions occur.  You are to implement 
 three different collision schemes, namely, linear probing, 
 rehashing, and chaining.
 */
import java.util.*;
public class HashCode_3G_Girish
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);  
      System.out.print("Enter the size of the array:  ");
      int arrayLength = keyboard.nextInt();       //20
      Hashtable table = new Hashtable(arrayLength);
      
      System.out.print("\nEnter the number of items:  ");
      int numItems = keyboard.nextInt();          //15
      System.out.print("\nThe Load Factor is " + (double)numItems/arrayLength);
      System.out.println();
      for(int i = 0; i < numItems; i++)
         table.add("Item "+i);
      System.out.println();
      System.out.print("Search for:  Item ");
      int i = keyboard.nextInt();
      String key = "Item " + i; 
      if(!table.contains(key))
         System.out.println(key + " NOT found");
   }
}
   
class Hashtable
{
   private int size;
   private Object[] table;
   public Hashtable(int numSlots)
   {
      size = numSlots;
      table = new Object[size];
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % size);
      if(table[index] == null)
      {
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = linearProbe(index);
         //index = rehash(index);
         //obj = chaining(index, obj);
         table[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }
   
   public int linearProbe(int ind)
   {
   
      while(table[ind] != null)
      {
         ind++;
         if(ind > table.length-1)
         {
            Object[] monkey = new Object[ind +1]; 
            for(int i = 0; i < monkey.length; i++)
            {
               monkey[i] = table[i];
            }
         
            table = monkey;
         } 
      }
      return ind;
   }
   
   public int rehash(int ind)
   {
      while(table[ind] != null)
      {
         ind = Math.abs((ind+3) % size); 
      }
      
      return ind; 
          
   }
   
   public Object chaining(int index, Object obj)
   {
      if(table[index] == null)
         return obj; 
      else
      {
      if(table[index] instanceof LinkedList)
      {
         ((LinkedList)table[index]).add(obj);
         return table[index];
      }
      else
      {
         LinkedList kiran = new LinkedList();
         kiran.add(table[index]);
         kiran.add(obj);
         return kiran; 
      }
      }
   
   }
   public boolean contains(Object obj)     //Big-O is O(____)
   {
      int index = Math.abs(obj.hashCode() % size);
      //you must implement searching for *each* collision strategy
      Object found = table[index];
      if(found.equals(obj))
      {
         System.out.println(obj + " at index " + index);
         return true;
      }
      else 
      {
       //linear probing
         for(int i = index; i < table.length; i++)
         {
            found = table[i];
            if(found.equals(obj))
            {
               System.out.println(obj + " at index " + i);
               return true;
            }
         }
       
       
       //rehash
         while(!found.equals(obj))
         {
            index = Math.abs((index+3) % size);
            found = table[index];
            if(found.equals(obj))
            {
               System.out.println(obj + " at index " + index);
               return true;
            }
         }
       
       //chaining
       
         if(found instanceof LinkedList)
         {
            if(((LinkedList)found).contains(obj))
            {
            System.out.println(obj + " at index " + index);
               return true;
            }
         }
      }
      return false;
         
         
   }
}
 
