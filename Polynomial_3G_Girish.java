  //Name: Kiran Girish   Date: 03/29/15
import java.util.*;
public class Polynomial_3G_Girish
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();
      poly.makeTerm(1, -4);
      poly.makeTerm(3, 2);
      poly.makeTerm(0, 2);
      System.out.println(poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
   	   	
      Polynomial poly2 = new Polynomial();
      poly2.makeTerm(1, -5);
      poly2.makeTerm(4, 2);
      poly2.makeTerm(0, -3);
      poly2.makeTerm(2, 1); 
      System.out.println(poly2.toString());
   	
     System.out.println(poly.add(poly2));
      System.out.println(poly.multiply(poly2));
   }
}


class Polynomial
{
   private Map<Integer, Integer> polyz; 

   public Polynomial ()
   {
      polyz = new HashMap<Integer, Integer>(); 
   }
   
   public void makeTerm(int e, int c)
   {
      polyz.put(e, c); 
   }
   
   public Map getMap()
   {
      return polyz;
   }
   
   public Set<Integer> keySet()
   {
   return polyz.keySet(); 
   }
   
   public boolean containsKey(int key)
   {
   if(this.keySet().contains(key))
   {
      return true;
   }
   return false; 
   }
   
   public String toString() 
   {
      String express = ""; 
      Set<Integer> exp = polyz.keySet(); 
      Iterator<Integer> expit = exp.iterator();
      ArrayList<Integer> backexp = new ArrayList<Integer>(); 
      ArrayList<Integer> backco = new ArrayList<Integer>(); 
      while(expit.hasNext())
      {
         int expo = expit.next(); 
         backexp.add(expo); 
         int coeff = polyz.get(expo); 
         backco.add(coeff); 
      }
   
      for(int i = backexp.size() - 1; i >= 0; i--)
      {
         int expon = backexp.get(i); 
         int coeffi = backco.get(i); 
         if(expon == 0)
            express += "" + coeffi; 
         else if(expon == 1)
         {
            if(coeffi == 1)
            {
               express += "" + "x "; 
            }
            else
            {
               express += "" + coeffi + "x ";
            }
         } 
         else
         {
            if(coeffi == 1)
            {
               express += "" + "x^" + expon; 
            }
            else
            {
               express += "" + coeffi + "x^" + expon;
            }
         }
         if(i < exp.size() && i > 0)
            express += " + ";     
      
      }
      
      return express;  
   
   }
   public double evaluateAt(double x)
   {
      double sum = 0.0; 
      Set<Integer> exp = polyz.keySet(); 
      Iterator<Integer> expit = exp.iterator();
      ArrayList backexp = new ArrayList(); 
      ArrayList backco = new ArrayList(); 
      while(expit.hasNext())
      {
         int expo = expit.next();
         int co = polyz.get(expo); 
         double val = co * Math.pow(x, expo); 
         sum += val; 
      }
      
      return sum;
      
   }
   
   public Polynomial add(Polynomial other)
   {
      Polynomial added = new Polynomial(); 
      Map<Integer, Integer> othmap = other.getMap(); 
      Set<Integer> polyexp = polyz.keySet();
    for(int pexp: polyexp)
      {
         int pco = polyz.get(pexp); 
         for(int oexp: other.keySet())
         {
            if(pexp == oexp)
            {
               pco += othmap.get(oexp);
            }
         }
        added.makeTerm(pexp, pco); 
       }
   for(int oexp: other.keySet())
   {
      int oco = othmap.get(oexp); 
      if(!added.containsKey(oexp))
      {
         added.getMap().put(oexp, oco);
      }
   }
     
      return added; 
   }
   
 
  
  public Polynomial multiply(Polynomial other)
   {
   int ex = 0; 
   int co = 0;
  Polynomial multed = new Polynomial();
  Map<Integer, Integer> othmap = other.getMap();  
  Set<Integer> okey = othmap.keySet(); 
  for(int key: polyz.keySet())
  {
      for(int oth: other.keySet())
      {
      
         Map<Integer, Integer> multmap = multed.getMap();
         ex = key + oth; 
         co = polyz.get(key) * othmap.get(oth);
         if(multmap.containsKey(ex))
         {
            co += multmap.get(ex);
         }
         
         multmap.put(ex, co); 
      }
   }
             
      return multed; 
   }
 

}
/*  
expected output
   2x^3 + -4x + 2
   10.0
   2x^4 + x^2 + -5x + -3
   2x^4 + 2x^3 + x^2 + -9x + -1
   4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 */