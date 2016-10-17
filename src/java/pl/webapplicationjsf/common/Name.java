/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.webapplicationjsf.common;

/**
 *
 * @author mariusz
 */
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import pl.webapplicationjsf.controllers.ApplicationController;


public class Name implements Serializable 
{
   private String first;
   private String last;
   private int age;
   private boolean editable;
  

   public Name(String first, String last, int age) {
      this.first = first;
      this.last = last;
      this.age = age;
   }
   public Name(String first, String last, int age,boolean editable) {
      this.first = first;
      this.last = last;
      this.age = age;
      this.editable=editable;
   }   

   public void setFirst(String newValue) { first = newValue; }
   public String getFirst() { return first; }
   

   public void setLast(String newValue) { last = newValue; }     
   public String getLast() 
   {
       return last; 
   }
   
   public void setAge(int newValue) { age = newValue; }
   public int getAge() { return age; }
   
   public void setEditable(boolean newValue) 
   { 
       editable = newValue; 
   }
   public boolean getEditable() 
   { 
       return editable; 
   }
}
