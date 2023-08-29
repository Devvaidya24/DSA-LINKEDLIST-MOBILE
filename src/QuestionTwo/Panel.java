package QuestionTwo;

/**
 *
 * @author Dev
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener, ComponentListener, ActionListener {

    //Array list for phone object
    ArrayList<Phone> phones = new ArrayList<Phone>();

    //public panel method to...    
    public Panel() {
        //adds key listeners to componenet listeners
        this.addKeyListener(this);
        this.addComponentListener(this);
        this.setFocusable(true);

        //creates the 300 phones however want it to be created using the keys and not exceed the 500 mark however these add to the array list
        for (int i = 0; i < 500; i++) {
            phones.add(new Phone());
        }

        //created timer object which calls action perform method every 16 milli sec
        Timer t = new Timer(16, this);
        t.restart(); //then timer will restart
    }

    //paint method to draw phone objects and handle the collisions
    @Override
    public void paint(Graphics g) {
        //calls paint method of JPanel superclass
        super.paintComponent(g);
        //for loop for array list of phone objects and calls the paint method
        for (Phone p : phones) {
            p.paint(g); 
        }

        //for loop to generate unique locations within the list of the phones
        for (int i = 0; i < phones.size(); i++) {
            for (int j = i + 1; j < phones.size(); j++) {
                //generates unique pairs which pairs up with another phone in the list
                phones.get(i).collision(phones.get(j));
            }
        }
    }
    
    //empty methods however, i wanted to add methods that would initialize and set keys to controll the number of phones added by pressing key
    // and be able to do by adding one of the repair object to clean virus which spreads around

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void componentResized(ComponentEvent ce) {

    }

    @Override
    public void componentMoved(ComponentEvent ce) {

    }

    @Override
    public void componentShown(ComponentEvent ce) {

    }

    @Override
    public void componentHidden(ComponentEvent ce) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); //calling repaint method 
    }
}
