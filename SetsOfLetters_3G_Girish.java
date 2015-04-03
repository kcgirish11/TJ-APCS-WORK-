// Name: Kiran Girish    Date: 03/15/15
import java.util.*;
import java.io.*;
public class SetsOfLetters_3G_Girish
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("declarationLast.txt"));
      String line = sc.nextLine(); 
      System.out.println(line);
         Set<Character> lower = new TreeSet<Character>();
         Set<Character> upper = new TreeSet<Character>(); 
         Set<Character> other = new TreeSet<Character>(); 
         for(int i = 0; i < line.length(); i++)
         {   
            char here = line.charAt(i);
            if(here <= 'Z' && here >= 'A')
            {
               upper.add(here);
            }
            else if (here >= 'a' && here <= 'z')
            {
               lower.add(here); 
            }
            else
            {
               other.add(here);
            }
         }
    
      Set intersectlow =  new TreeSet<Character>(lower);
      Set intersecthigh =  new TreeSet<Character>(upper);
      Set intersectother = new TreeSet<Character>(other);
       System.out.println("Lower Case: " + lower);
         System.out.println("Upper Case: " + upper); 
         System.out.println("Other: " + other);
         System.out.println();
      while(sc.hasNextLine())
      { 
         line = sc.nextLine(); 
         System.out.println(line);
         lower = new TreeSet<Character>();
         upper = new TreeSet<Character>(); 
         other = new TreeSet<Character>(); 
         for(int i = 0; i < line.length(); i++)
         {   
            char here = line.charAt(i);
            if(here <= 'Z' && here >= 'A')
            {
               upper.add(here);
            }
            else if (here >= 'a' && here <= 'z')
            {
               lower.add(here); 
            }
            else
            {
               other.add(here);
            }
         }
 
         System.out.println("Lower Case: " + lower);
         intersectlow.retainAll(lower);
         System.out.println("Upper Case: " + upper);
         intersecthigh.retainAll(upper); 
         System.out.println("Other: " + other);
         intersectother.retainAll(other);
         System.out.println();
      }
      
      System.out.println("Common lower case: " + intersectlow); 
      System.out.println("Common upper case: " + intersecthigh);
      System.out.println("Common other: " + intersectother);
      
   }
}