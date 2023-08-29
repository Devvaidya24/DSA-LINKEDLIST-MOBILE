package QuestionTwo;

import java.awt.*;

/**
 *
 * @author Dev Vaidya
 */
public class Phone {

    //initialzing variables
    public int x, y;
    int vx, vy;
    int status = 0;
    int recoverTime;

    static int numInfected = 0;

    //constructor for new phone objects to initialize the locations velocity and time
    public Phone() {

        //setting location randomly within the bounds of the screen
        x = (int) (Math.random() * 1000 );
        y = (int) (Math.random() * 1000 );

        //setting initials status of the pjone to be infected or not
        if (Math.random() < 0.20) {
            status = 1;
        }

        //setting the velocity randomly with the range
        vx = (int) (Math.random() * (10 + 1) + - 5);
        vy = (int) (Math.random() * (10 + 1) + - 5);

        //setting the recover time randomly within a certain range 
        recoverTime = (int) (Math.random() * (6000 - 5000 + 1) + 5000);
    }

    //checking if phon collides with another phone object and and updated status
    public void collision(Phone p2) {
        Rectangle ph1 = new Rectangle(p2.x, p2.y, 10, 10);
        Rectangle ph2 = new Rectangle(this.x, this.y, 10, 10);

        //checks if the two phone objects of insersect
        if (ph1.intersects(ph2)) {
            //if this phone objects insersect
            if (this.status == 1 && p2.status == 0) {
                p2.status = 1;
                numInfected++;
                //if the other phone is infected and this phone will not infect this phone
            } else if (this.status == 0 && p2.status == 1) {
                this.status = 1;
                numInfected++;
            }
        }
    }

    public void paint(Graphics g) {

        //switch method to set these colors of the phone based on there status
        switch (status) {
            case 0:
                //setting cyan for the phone
                g.setColor(Color.cyan);
                break;
            case 1:
                //setting the infected phones
                g.setColor(Color.red);
                break;
            default:
                //setting the fixed phones
                g.setColor(Color.MAGENTA);
                break;
        }

        //if the phone is infected then it will update the recovery time and change the statuses
        if (status == 1) {
            //updates recover time
            recoverTime -= 16;

            if (recoverTime <= 0) {
                status = 2;
                numInfected--;
            }
        }

        //updates the postions 
        x += vx;
        y += vy;

        //if phone hits left right boundary then reverse them or rebound them
        if (x < 0 || x >= 990) {
            vx *= -1;
        }
        //if phone hits top and bottom then rebound
        if (y < 0 || y >= 990) {
            vy *= -1;
        }

        //draws the phone as a filledovals using the color and postioning done above
        g.fillOval(x, y, 6, 6);
    }
}
