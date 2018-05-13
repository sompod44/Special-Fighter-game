/*
    Bismillahir Rahmanir Rahim
 */
// Am very week in English. so plz don't mind
package special.fighter; // Here imput package name 

// 11 to 23 line import files
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Sompod_Programmer
 */
public class GraphicePanel extends JPanel implements ActionListener, KeyListener {

    private static final int timelapse = 80; // this variable set Timer call time
    private Timer timer; // Here create timer refarence variable
    int a = 580, b = 510; // This two variable Player jet praimary position
    public JLabel textfield = new JLabel(); // This JLable use for print Playerjet X - Axis and Y - Axis Always 
    public JLabel resultjlable = new JLabel(); // This JLable use for print scoure 
    StringBuilder stringBuilder = new StringBuilder(); // This stringbuilder use for store playerjet x,y Axis position
    StringBuilder resultshow = new StringBuilder(); // This stringbuilder use for store scoure

    private BufferedImage image1, image2, image3;
    /*
    image1 use for print background picture.
    image2 use for print playerJet
    image3 use for print Bullet
     */

    private BufferedImage[] pic = new BufferedImage[6]; // This pic Array use for store 6 enemy jet picture.
    player_bullet[] pb = new player_bullet[6]; // Here create 6 object of Player_bullet class.
    Enemy[] enemy = new Enemy[6]; // this enemy object store different position of enemy jet .
    int p = 1;
    Random random = new Random();
    int e1 = random.nextInt();
    int enemypoint = 0, mypoint = 0;

    GraphicePanel() { // this is constractor
        try {
            image1 = ImageIO.read(getClass().getClassLoader().getResource("skybackgound.jpg"));
            image2 = ImageIO.read(getClass().getClassLoader().getResource("playerjet.png"));
            image3 = ImageIO.read(getClass().getClassLoader().getResource("playerbullet.png"));

        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            pic[0] = ImageIO.read(getClass().getClassLoader().getResource("jet1.png"));
            pic[1] = ImageIO.read(getClass().getClassLoader().getResource("jet2.png"));
            pic[2] = ImageIO.read(getClass().getClassLoader().getResource("jet3.png"));
            pic[3] = ImageIO.read(getClass().getClassLoader().getResource("jet4.png"));
            pic[4] = ImageIO.read(getClass().getClassLoader().getResource("jet5.png"));
            pic[5] = ImageIO.read(getClass().getClassLoader().getResource("jet6.png"));

        } catch (Exception e) {
            System.out.println(e);
        }
        timer = new Timer(timelapse, this);
        timer.start();

        addKeyListener(this); // this is for key listener 
        setFocusable(true); // This method need for key listener
        setFocusTraversalKeysEnabled(false); // This method need for key listener

        textfield.setBounds(10, 20, 100, 200);

        add(textfield);
        textfield.setForeground(Color.YELLOW);
        resultjlable.setBounds(10, 700, 100, 200);
        add(resultjlable);
        resultjlable.setForeground(Color.GREEN);

        for (int i = 0; i < 6; i++) {
            pb[i] = new player_bullet();

        }
        for (int i = 0; i < 6; i++) {
            enemy[i] = new Enemy();

        }

        for (int i = 0; i < 6; i++) {  // This for loop use for initialize properties of enemy objects
            enemy[i].b = true;
            enemy[i].x = random.nextInt(1260);
            enemy[i].y = random.nextInt(300);
            enemy[i].dx = 2 + random.nextInt(10);
            enemy[i].dy = 2 + random.nextInt(10);

        }

    }

    int som = 36; // this extra value for add with bullet X Axis . so that bullet position set into middle 

    // those value are store value of bullet x,y asix
    int getbullet0X, getbullet0Y,
            getbullet1X, getbullet1Y,
            getbullet2X, getbullet2Y,
            getbullet3X, getbullet3Y,
            getbullet4X, getbullet4Y;

    @Override
    protected void paintComponent(Graphics g) { // This method print object into jpanel
        super.paintComponent(g);

        g.drawImage(image1, 0, 0, this); // Here print background picture
        stringBuilder.append("X Axis : ");
        stringBuilder.append(a);
        stringBuilder.append(" , Y Axis : ");
        stringBuilder.append(b);
        new Jet(g, image2, a, b, this); // Here print player Jet into jet class
        textfield.setText(stringBuilder.toString());

        stringBuilder.delete(0, stringBuilder.length());
        resultshow.append("Sompod Hit :=> ");
        resultshow.append(mypoint);
        resultshow.append(" Times. And Enemy Hit :=> ");
        resultshow.append(enemypoint);

        resultjlable.setText(resultshow.toString());

        resultshow.delete(0, resultshow.length());

        for (int i = 0; i < 6; i++) { // Here initialize  jet x,y exis into all bullet . 

            pb[i].x = a; // a mean player jet x Axis
            pb[i].y = b; // b mean player jet y Axis
        }

        if (p == 1) { // when p == 1 then print only 3 bullet
            g.drawImage(image3, pb[0].x + som, pb[0].y - 70, 30, 40, this);
            getbullet0X = pb[0].x + som;
            getbullet0Y = pb[0].y - 70;
            g.drawImage(image3, pb[2].x + som, pb[2].y - 70 - 90 - 90, 30, 40, this);
            getbullet2X = pb[2].x + som;
            getbullet2Y = pb[2].y - 70 - 90 - 90;
            g.drawImage(image3, pb[4].x + som, pb[4].y - 70 - 90 - 90 - 90 - 90, 30, 40, this);
            getbullet4X = pb[4].x + som;
            getbullet4Y = pb[4].y - 70 - 90 - 90 - 90 - 90;

        }
        if (p == 2) { // when p == 2 then print only 2 bullet
            g.drawImage(image3, pb[1].x + som, pb[1].y - 70 - 90, 30, 40, this);
            getbullet1X = pb[1].x + som;
            getbullet1Y = pb[1].y - 70 - 90;
            g.drawImage(image3, pb[3].x + som, pb[3].y - 70 - 90 - 90 - 90, 30, 40, this);
            getbullet3X = pb[3].x + som;
            getbullet3Y = pb[3].y - 70 - 90 - 90 - 90;

        }

        for (int i = 0; i < 6; i++) { // this use for print enemy jet into jpanel 

            if (enemy[i].b) { // If player jet does not kill enemy jet then will peint enemy jet into jpanel
                g.drawImage(pic[i], enemy[i].x, enemy[i].y, 50, 100, this);
            }

        }
        int remakex = 15 + random.nextInt(1000); // Here get just different value of x Axis . 
        int remakey = 15 + random.nextInt(300); // Here get just different value of y Axis . 

        for (int i = 0; i < 6; i++) { // this loop use for check enemy jet kill or not 

            if (!enemy[i].b) { // If enemy jet are kill by player . 
                enemy[i].b = true; // here enemy jet get ready for again fly.
                enemy[i].x = remakex; // Byt here enemy jet get new x - Axis 
                enemy[i].y = remakey; // Byt here enemy jet get new y - Axis 

            }

        }

    }

    int s = 0;

    @Override
    public void actionPerformed(ActionEvent e) { // This method call Timer class . 

        // Those double variable use for vanish enemy jet from jpanel
        double c0x, c0y,
                c1x, c1y,
                c2x, c2y,
                c3x, c3y,
                c4x, c4y,
                jetx, jety,
                centerx2, centery2,
                r0,
                r1,
                r2,
                r3,
                r4,
                jetradius,
                radius2;

        for (int i = 0; i < 6; i++) { // This loop change enemy jet x,y Axis . Thats why enemy jet are moving
            enemy[i].x += enemy[i].dx;
            enemy[i].y += enemy[i].dy;

            if (enemy[i].x < 10 || enemy[i].x > 1260) { // if enemy jet x Axis are cross this limit then x Axis bounse
                enemy[i].dx = -enemy[i].dx;
            } else if (enemy[i].y < 10 || enemy[i].y > 500) { // if enemy jet y Axis are cross this limit then x Axis bounse
                enemy[i].dy = -enemy[i].dy;
            }

        }

        jetx = 50; // this variable hulf of player jet width
        jety = 50; // this variable hulf of player jet hieght

        // here 234 to 244 line variable x and y represent every bullet center x and y 
        c0x = (getbullet0X + 30) / 2;
        c0y = (getbullet0Y + 40) / 2;
        c1x = (getbullet1X + 30) / 2;
        c1y = (getbullet1Y + 40) / 2;
        c2x = (getbullet2X + 30) / 2;
        c2y = (getbullet2Y + 40) / 2;
        c3x = (getbullet3X + 30) / 2;
        c3y = (getbullet3Y + 40) / 2;
        c4x = (getbullet4X + 30) / 2;
        c4y = (getbullet4Y + 40) / 2;

        for (int i = 0; i < 6; i++) { // this loop check every enemy jet positon for bullet are touch enemy jet or no .
            centerx2 = (enemy[i].x + 50) / 2; // here 50 is enemy jet width
            centery2 = (enemy[i].y + 100) / 2; // here 100 is enemy jet height
            r0 = Math.sqrt(Math.pow((c0x - centerx2), 2) + Math.pow((c0y - centery2), 2)); // here get distence butween bullet and enmey jet.
            r1 = Math.sqrt(Math.pow((c1x - centerx2), 2) + Math.pow((c1y - centery2), 2)); // here get distence butween bullet and enmey jet.
            r2 = Math.sqrt(Math.pow((c2x - centerx2), 2) + Math.pow((c2y - centery2), 2)); // here get distence butween bullet and enmey jet.
            r3 = Math.sqrt(Math.pow((c3x - centerx2), 2) + Math.pow((c3y - centery2), 2)); // here get distence butween bullet and enmey jet.
            r4 = Math.sqrt(Math.pow((c4x - centerx2), 2) + Math.pow((c4y - centery2), 2)); // here get distence butween bullet and enmey jet.

            jetradius = Math.sqrt(Math.pow((jetx - centerx2), 2) + Math.pow((jety - centery2), 2));  // here get distence butween player jet and enmey jet.

            radius2 = (100 / 2) + (50 / 2); // Here 100 is player jet width and Here 50 is enemy jet width

            if (jetradius <= radius2) {
                ++enemypoint;

            }
            if (r0 <= ((30 / 2) + (50 / 2)) || r1 <= ((30 / 2) + (50 / 2)) || r2 <= ((30 / 2) + (50 / 2)) || r3 <= ((30 / 2) + (50 / 2)) || r4 <= ((30 / 2) + (50 / 2))) { // Here 30 is width of bullet and 50 is width of jet 
                ++mypoint;
                enemy[i].b = false;

            }
        }
        repaint(); // This again print into jpanel, Its called "paintComponent(Graphics g)" this method

        if (s == 0) { // This mechanism use for print bullet in different times
            p = 2; // when p == 2 then print 2 bullet
            s = 1;
        } else {
            p = 1; // when p == 2 then print 3 bullet 
            s = 0;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // When we pressed Key from keypad then this method are called
        int value = e.getKeyCode();  // this int variable store key code which we are pressed 
        if (value == KeyEvent.VK_LEFT) {
            if (a <= 5) { // This "a" variable is global variable . which are player jet X - Axis
                a += 0; // if a is less or equal of 5 then player jet position does not changes

            } else { // Other wish player jet Axis are change
                a -= 20;

            }

        }
        if (value == KeyEvent.VK_RIGHT) {
            if (a >= 1255) { // This "a" variable is global variable . which are player jet X - Axis
                a += 0;

            } else {
                a += 20;

            }

        }
        if (value == KeyEvent.VK_UP) { // This "b" variable is global variable . which are player jet Y - Axis
            if (b <= 0) {
                b += 0;

            } else {
                b -= 20;

            }

        }
        if (value == KeyEvent.VK_DOWN) { // This "b" variable is global variable . which are player jet Y - Axis
            if (b >= 630) {
                b = b + 0;

            } else {
                b = b + 20;

            }
        }
         
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
