/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.webapplicationjsf.controllers;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.event.ActionEvent;

import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;  // dodanie modelu elementów selecji 
import javax.faces.model.SelectItemGroup; // dodanie modelu grupowanie elementów

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectMany;



/**
 *
 * @author mariusz
 */
@ManagedBean(name="logonController")
@SessionScoped
public class LogonController 
{
private String name="student";
private String password="";
private int iloscBlednychLogowan=0;
private String errorCode="Brak widoku o taki identyfikatorze";
private String kod="122*212121*211212";
private String jezyk="Polski";
private boolean czyWidoczny=true;
private boolean czyAdministrator=false;
private int[] userTypes;
private int userRole;
private int count=0;
private int rok;
private String[] kolor;
private int liczba;
private int widok=2;//sterowanie identyfikatorem widoku w regule nawigacji <navigation-case> <IF> w pliku FacesConfig

//private java.util.List<SelectItemGroup> wybraneKategorie;
private int[] wybraneKategorie;


//inicjalizaja dostêpny opcji dla elementów wyboru i selekcji
//dla znacznika f:selectItems
private static SelectItem[] userRolesItems =
{
new SelectItem(1,"Pracownik"),
new SelectItem(2,"Kierownik"),
new SelectItem(3,"Dyrektor")
};

private static SelectItem[] userTypesItems =
{
new SelectItem(1,"U¿ytkownik"),
new SelectItem(2,"Administrator"),
new SelectItem(3,"U¿ytkownik zaawansowany")
};

//towary i kategorie - grupowanie elementów list

private static SelectItem[] kategorieAGD =
{
new SelectItem(11,"Pralki"),
new SelectItem(12,"Zmywarki"),
new SelectItem(13,"Lodówki")
};
private static SelectItem[] kategorieKom =
{
new SelectItem(21,"PC"),
new SelectItem(22,"Laptop"),
new SelectItem(23,"Notebook")
};
private static SelectItem[] kategorieRTV =
{
new SelectItem(31,"Telewizory"),
new SelectItem(32,"DVD"),
new SelectItem(33,"BlueRay")
};

private SelectItemGroup agd = new SelectItemGroup("AGD","art.agd",false,kategorieAGD);
private SelectItemGroup kom =new SelectItemGroup("Komputery","art.komputerowe",false,kategorieKom);
private SelectItemGroup rtv =new SelectItemGroup("RTV","art.radiowo telewizyjne",false,kategorieRTV);

private SelectItem[] kategorieItems =
{
agd,kom,rtv
};




//wstrzykniêcie komponentu o zasiêgu aplikacji do w³aœciwoœci
@ManagedProperty(value="#{applicationController}")
private ApplicationController applicationControllerReference;

public String getName(){return name;}
public void setName(String newValue) { name = newValue; }
public String getPassword() { return password; }
public void setPassword(String newValue) { password = newValue; }
public int getIloscBlednychLogowan() { return iloscBlednychLogowan; }
public String getKod(){return kod;}
public void setKod(String newValue){this.kod=newValue;}
public String getJezyk(){return jezyk;}
public void setJezyk(String newValue){this.jezyk=newValue;}
public boolean getCzyWidoczny(){return czyWidoczny;}
public void setCount(int newValue){this.count=newValue;}
public int getCount(){return count;}
public boolean getCzyAdministrator(){return czyAdministrator;}
public void setCzyAdministrator(boolean newValue){czyAdministrator=newValue;}
public int[] getUserTypes() { return userTypes; }
public void setUserTypes(int[] newValue) { userTypes = newValue; }
public int getUserRole() { return userRole; }
public void setUserRole(int newValue) { userRole = newValue; }
public int getRok() { return rok; }
public void setRok(int newValue) { rok = newValue; }
public String[] getKolor() { return kolor; }
public void setKolor(String[] newValue) { kolor = newValue; }

public SelectItem[] getUserTypesItems() {  return userTypesItems; }
public SelectItem[] getUserRolesItems() {  return userRolesItems; }

//grupowanie elementów menu
public SelectItem[] getKategorieItems() { return kategorieItems; }

public void setWybraneKategorie(int[] newValue) 
{ 
    wybraneKategorie = newValue; 
}
public int[] getWybraneKategorie() 
{ 
    return wybraneKategorie; 
}


public String getErrorCode()
{
return this.errorCode;    
}

//zdefiniowanie œciezek do widoków w postaci sta³ych 
private static final String ROOT = "/views/";
private static final String SECURITY_FOLDER = "security/";

public void setApplicationControllerReference(ApplicationController newValue) 
{
    this.applicationControllerReference = newValue;
}


public int getLiczba() { return liczba; }
public void setLiczba(int newValue) { liczba = newValue; }

// konstruktor komponentu zarz¹dzanego LogonController
public LogonController()
{
//inicjalizacja zmiennych komponentu    
//name="student";
//password="student123";
//name = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
}

@PostConstruct
public void initialize()
{
//inicjalizacja zmiennych komponentu    
applicationControllerReference.setWersjaAplikacji("testowa"); 
//zbudowanie zmiennej dla selectGroupItem
}
@PreDestroy
public void shutdown()
{
    
}
//obs³uga akcji logowania strona wywo³anie ze strony index.xhtml
//metoda zwraca zasób do którego ma nast¹piæ przekierowanie 
// zgodnie z nawigacj¹
public String login()
{
String sWersjaAplikacji = applicationControllerReference.getWersjaAplikacji();
boolean bZalogowany=false;

try
{

if (name.equals("student") && password.equals("student123"))
{
bZalogowany=true;    
}

if (bZalogowany)
{
//return "views/mainWindow";    //bezposrednio do strony
return ROOT+"mainWindow";    //bezposrednio do strony z wykorzystaniem sta³ej 
//return "main";  // przez identyfikator widoku zdefiniowany w faces-config.xml
}
else
{
iloscBlednychLogowan++;    
return "index";//ponownie ekran logowania z bledami
}
}
catch(Exception ex)
{
errorCode=ex.toString();    
return "error.xhtml";    
}
}

public String save()
{
return null;    
}

public String logout()
{
//zamkniecie otwartych polaczen , sesji itd. obiekt FacesContext
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//nie ma wywo³ania przez przez views/  poniewa¿ aktualnym katalogiem aplikacji 
//jest ju¿ w tej chwili /views
return "logoutWindow.xhtml?faces-redirect=true"; //bezp[oœrednio 
  
}

public void languageChange(ActionEvent event)
{ 
  //zastosowanie atrybutów przes³anych ze strony
  String data = (String)event.getComponent().getAttributes().get("jezyk");
  jezyk=data;
}

    public String dodaj_wyrazy(String value1, String value2)
    {
    return value1+"---"+value2;    
    }
    public double dodaj_liczby(double value1,double value2)
    {
    return value1+value2;    
    }

    public int getWidok() {
        return widok;
    }

    public void setWidok(int widok) {
        this.widok = widok;
    }

}
