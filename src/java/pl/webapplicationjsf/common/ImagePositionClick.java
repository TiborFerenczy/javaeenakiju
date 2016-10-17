/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.webapplicationjsf.common;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/**
 *
 * @author mariusz
 */
@ManagedBean
@SessionScoped
public class ImagePositionClick 
{
private int x=0;
private int y=0;
private String outcome=""; //pokaz ten sam widok

//obiekty niezarz¹dzane s¹ tworzone w zasiêgu widoku
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }




public void processActionEvent(ActionEvent event)
{
FacesContext context = FacesContext.getCurrentInstance();  
String clientId = event.getComponent().getClientId(context);
java.util.Map requestParams = context.getExternalContext().getRequestParameterMap();

x = new Integer((String) requestParams.get(clientId + ".x")).intValue();
y = new Integer((String) requestParams.get(clientId + ".y")).intValue();


outcome=null;
}

public String navigate()
{
return outcome;    
}
        
}
