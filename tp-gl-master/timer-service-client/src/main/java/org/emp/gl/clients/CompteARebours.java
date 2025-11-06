package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CompteARebours implements TimerChangeListener {
    private String name;
    private TimerService timerService;
    private int compteur;
    

    public CompteARebours(String name, TimerService timerService, int initialValue) {
        this.name = name;
        this.timerService = timerService;
        this.compteur = initialValue;
        this.timerService.addTimeChangeListener(this);
        System.out.println("Compte à rebours " + name + " initialisé avec " + initialValue + " secondes");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("seconde".equals(evt.getPropertyName()) ) {
            if (compteur > 0) {
                System.out.println(name + " : " + compteur + "s");
                compteur--;
            } else if (compteur == 0) {
                System.out.println(name + " : TERMINÉ !");
                timerService.removeTimeChangeListener(this);
                
            }
        }
    }
    /*public void propertyChange(PropertyChangeEvent evt) {
        if ("seconde".equals(evt.getPropertyName()) ) {
            if (compteur > 0) {
                System.out.println(name + " : " + compteur + "s");
                compteur--;
            } else if (compteur == 0) {
                System.out.println( name + " : TERMINÉ !");
                
                timerService.removeTimeChangeListener(this);
                
            }
        }
    }*/
}
