//Name:  Kiran Girish              Date: 03/29/15
import java.util.*;
public class HashingAWidget_3G_Girish
{
   public static void main(String[] args)
   {
      Set<Widget> tSet = new TreeSet<Widget>();
      Set<Widget> hSet = new HashSet<Widget>();
   	
      Widget a = new Widget(2,3);   //same or different?
      Widget b = new Widget(2,3);
      Widget c = new Widget(2,3);
     // c = b;
      
      tSet.add(a); 
      tSet.add(b);
      tSet.add(c);
    
      hSet.add(a); 
      hSet.add(b);
      hSet.add(c); 
      
      System.out.println(a.hashCode()+ " "+b.hashCode() + " " + c.hashCode());
      
      System.out.println("TreeSet:  " + tSet);
      System.out.println("HashSet:  " + hSet);
   }
}

/*************************************** 
Modify the Widget class so that it hashes on its
values, not on its address.  Be sure that compareTo(),
equals(Object) and hashCode() agree with each other.
****************************************/

class Widget implements Comparable<Widget>
{
   private int myPounds, myOunces;
   public Widget()
   {
      myPounds = myOunces = 0;
   }
   public Widget(int x)
   {
      myPounds = x;
      myOunces = 0;
   }
   public Widget(int x, int y)
   {
      myPounds = x;
      myOunces = y;
   }
   public Widget(Widget arg)
   {
      myPounds = arg.getPounds();
      myOunces = arg.getOunces();
   }
   public int getPounds()
   {
      return myPounds;
   }
   public int getOunces()
   {
      return myOunces;
   }
   public void setPounds(int x)
   {
      myPounds = x;
   }
   public void setOunces(int x)
   {
      myOunces = x;
   }
  
   public int compareTo(Widget w)
   {
      if(this.getPounds() == w.getPounds())
      {
         return this.getOunces() - w.getOunces();
      }
   
      return this.getPounds() - w.getPounds();
   }
   public boolean equals(Widget arg) 
   {
      if(this.compareTo(arg) == 0)
         return true;
      return false;
   }
    
   public String toString()
   {
      String wid = "Pounds: " + this.getPounds() + " Ounces: " + this.getOunces();
      return wid;
   }
   
   public boolean equals(Object arg)
   {
      if(this.compareTo((Widget) arg) == 0)
      {
         return true;
      }
      return false;
   }
   
   public int hashCode()
   {
   
   return this.getPounds()*16 + this.getOunces();
   
   }
}