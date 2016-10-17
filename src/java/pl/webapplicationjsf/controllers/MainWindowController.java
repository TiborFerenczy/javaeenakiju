/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.webapplicationjsf.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import pl.webapplicationjsf.common.Name;

import java.util.List;
import javax.faces.event.ActionEvent;

import javax.faces.component.UISelectBoolean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
/**
 *
 * @author mariusz
 */
@ManagedBean
@ViewScoped
public class MainWindowController 
{
private int rowCount;    
private java.util.List<Name> dataList=new java.util.ArrayList();
private String dataListAsString="";
private boolean tableVisible=false;
private String AjaxViewId="++first--";

@ManagedProperty(value="#{logonController}") 
private LogonController logonControllerReference;


private String userName = "";
private String userNameTemp = "Puste";//tymczasowo jako parametr ¿¹dania jsfParametersExample

private String password1;
private String password2;

private String linkTableExample="jsfTableExample";
private String linkParametersExample="jsfParametersExample";

    /**
     * Creates a new instance of mainWindowController
     */
   public MainWindowController()
   {
   dataList.add(new Name("Tomasz","Kowalski",37));    
   dataList.add(new Name("Jacek","£êcki",45));
   dataList.add(new Name("Alicja","Nowakowska",30));
   dataList.add(new Name("Maciej","S³oñ",25));
   dataList.add(new Name("Adam","Kozak",45));
   dataList.add(new Name("Robert","Lokowski",30));
   dataList.add(new Name("Rafa³","Ciemny",25));   
   dataList.add(new Name("Zygmunt","Kot",30));
   dataList.add(new Name("Andrzej","Wolny",25));
   
   dataListAsString=new String("Tomasz Kowalski\nJacek £êcki\nAlicja Nowakowska\nMaciej S³oñ");
   

   }    
   
   public String saveData()
   {
   //przes³anie i zapis danych z formularza 
   //po zapisaniu danych ustawa status wiersza editable=false
   java.util.Iterator<Name> nameIterator = dataList.iterator();
   while(nameIterator.hasNext())
   {
   nameIterator.next().setEditable(false);    
   }
   return "";    
   }
    //kolejne wywo³ania Ajaxa  
    public void setAjaxViewId(String newValue)
    {
    AjaxViewId=newValue;    
    }
    public String getAjaxViewId()
    {
    AjaxViewId=AjaxViewId+"--Next---";    
    return AjaxViewId;   
    }
    
   public void setLogonControllerReference(LogonController newValue) 
    {
    this.logonControllerReference = newValue;
    userName=logonControllerReference.getName();
    }
    public java.util.List getDataList()
    {
    return dataList;
    } 
    public String getDataListAsString()
    {
     return dataListAsString;
    }
    public void setDataListAsString(String newValue)
    {
     dataListAsString=newValue;
    }
    
    
   
    public void setPassword1(String newValue)
    {
    password1=newValue;    
    }
    public void setPassword2(String newValue)
    {
    password2=newValue;    
    }
    public String getPassword1()
    {
    return password1;    
    }
    public String getPassword2()
    {
    return password2;    
    }    
    public String getLinkParametersExample()
    {
    return linkParametersExample;    
    }  
    public String getLinkTableExample()
    {
    return linkTableExample;    
    }      
    
    public String navigateToJsfTableExample()
    {
    return linkTableExample;     
    }
    
    public void setUserName(String newValue)
    {
    userName=newValue;    
    }
    public String getUserName()
    {
    return userName;    
    }
    public void setTableVisible(boolean newValue)
    {
    tableVisible=newValue;    
    }
    public boolean getTableVisible()
    {
    return tableVisible;    
    }    
    public void showHideTable()
    {
    tableVisible=!tableVisible;    
    }
    

    public void visibleChange(Name name)
    {
        int indexObject = dataList.indexOf(name);
        dataList.set(indexObject,name);
        
    }
    //usuniecie rekordu z listy, JSF wi¹¿e tabele ze strony 
    //z pozycj¹ w liœcie i usuwa j¹
    public void deleteRow(Name name)
    {
    int indexObject = dataList.indexOf(name); 
    dataList.remove(indexObject);
    }
    //dodanie rekordu do listy, JSF wi¹¿e tabele ze strony 
    //z pozycj¹ w liœcie i dodaje now¹ pozycj¹ typu Name  do edycji   
    public void addRow(Name name)
    {
    int indexObject = dataList.indexOf(name);
    Name newNameRow = new Name("","",0,true);
    dataList.add(indexObject+1, newNameRow);
    }
    
    public String dodaj_wyrazy(String value1, String value2)
    {
    return value1+"---"+value2;    
    }
    public double dodaj_liczby(double value1,double value2)
    {
    return value1+value2;    
    }
    
    public String getUserNameTemp ()
    {
    return this.userNameTemp;    
    }
    public void setUserNameTemp (String sUserNameTemp)
    {
    this.userNameTemp=sUserNameTemp;
    } 
}
