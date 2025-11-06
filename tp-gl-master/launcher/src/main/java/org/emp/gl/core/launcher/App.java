package org.emp.gl.core.launcher;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.clients.HorlogeSimpleGUI;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();

    }

    private static void testDuTimeService() {
        TimerService timer =new DummyTimeServiceImpl();
        Horloge horloge1 = new Horloge("Num 1",timer) ;
        Horloge horloge2 = new Horloge("Num 2",timer) ;
        HorlogeSimpleGUI horlogeGraphique = new HorlogeSimpleGUI(timer);
        CompteARebours compte1= new  CompteARebours("Num 1",timer,5);
        
        
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
