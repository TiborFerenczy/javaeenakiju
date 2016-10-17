/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.webapplicationjsf.controllers;
/**
 *
 * @author mariusz
 */
public class ControllerDefinedXML {

private ApplicationController applicationController;

    public ControllerDefinedXML() {
    }

    public void setApplicationController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }
    public String getWersjaAplikacji()
    {
        return applicationController.getWersjaAplikacji();
    }
}
