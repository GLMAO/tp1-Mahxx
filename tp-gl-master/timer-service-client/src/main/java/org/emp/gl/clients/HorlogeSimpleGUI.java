package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HorlogeSimpleGUI extends JFrame implements PropertyChangeListener {
    private TimerService timerService;
    private JLabel timeLabel;

    public HorlogeSimpleGUI(TimerService timerService) {
        this.timerService = timerService;
        
        // S'inscrire pour recevoir les mises à jour
        timerService.addTimeChangeListener(this);
        
        // Configurer la fenêtre
        setTitle("Horloge Simple");
        setSize(250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer
        
        // Créer le label pour l'heure
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setForeground(Color.BLUE);
        
        // Ajouter à la fenêtre
        add(timeLabel);
        
        // Afficher
        setVisible(true);
        
        // Mettre à jour l'heure initiale
        updateTime();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Se mettre à jour à chaque seconde
        if ("seconde".equals(evt.getPropertyName())) {
            updateTime();
        }
    }

    private void updateTime() {
        String time = String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes());
        timeLabel.setText(time);
    }
}
