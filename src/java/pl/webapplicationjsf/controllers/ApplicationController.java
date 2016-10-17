/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.webapplicationjsf.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author mariusz
 */
@ManagedBean(name="applicationController", eager=true)
@ApplicationScoped
public class ApplicationController 
{
private String sWersjaAplikacji = "";
private java.util.List<String> listaUprawnien;
private String[] tablicaUprawnien;
    /**
     * Creates a new instance of applicationController
     */
    public ApplicationController() 
    {
    sWersjaAplikacji="2013.01.201-21";
    listaUprawnien = new java.util.ArrayList();
    listaUprawnien.add("administrator");
    listaUprawnien.add("u¿ytkownik"); 
    listaUprawnien.add("przegladaj¹cy");
    listaUprawnien.add("serwis");
    
    tablicaUprawnien = new String[] {"administratorT","u¿ytkownikT","przegl¹daj¹cyT","serwisT"};
    }
    
    @PostConstruct
    public void initialize()
    {
    //inicjalizacja zmiennych komponentu    
    //setWersjaAplikacji("testowa");  

    }
    
    public String getWersjaAplikacji()
    {
     return sWersjaAplikacji;   
    }
    public void setWersjaAplikacji(String newValue)
    {
     sWersjaAplikacji = newValue ;   
    }  
    public String[] getTablicaUprawnien()
    {
     return tablicaUprawnien;   
    }    
    public void setListaUprawnien(java.util.List<String> newValue)
    {
     this.listaUprawnien=newValue;   
    }    
    public java.util.List<String> getListaUprawnien()
    {
     return listaUprawnien;   
    }

}
