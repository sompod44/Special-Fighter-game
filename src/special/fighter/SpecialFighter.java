
/*
    Bismillahir Rahmanir Rahim
 */
// Am very week in English. so plz don't mind
package special.fighter;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Sompod_Programmer
 */
public class SpecialFighter extends JFrame {

    public SpecialFighter() {
        Container containpain = getContentPane();
        containpain.add(new GraphicePanel());
        setTitle("Galaxy Fighter Game. Developed By : SOMPOD ");
        setSize(1255, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
