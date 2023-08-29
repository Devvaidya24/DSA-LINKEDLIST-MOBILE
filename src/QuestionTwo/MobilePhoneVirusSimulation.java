package QuestionTwo;

/**
 *
 * @author Dev Vaidya
 */
import javax.swing.JFrame;

public class MobilePhoneVirusSimulation {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mobile Phone Virus Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        
        frame.getContentPane().add(panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

}
