
/*
    Bismillahir Rahmanir Rahim
 */
// Am very week in English. so plz don't mind
package AllJFrame;
// Am very week in English. so plz don't mind
//This is main class of galaxy figher games

import AllButton.AllIntroButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import special.fighter.SpecialFighter;

/**
 *
 * @author Sompod_Programmer
 */
public class IntroFrame extends JFrame implements ActionListener {

    private AllIntroButton allIntroButton;
    JLabel jlable1, jlable2;

    public IntroFrame() {
        Container containpain = getContentPane(); // this line use for get full container of jframe
        containpain.setLayout(new BorderLayout()); // here set container layout type
        setTitle("Galaxy Fighter Game");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // This use for when are click in cross button then all program gone close

        allIntroButton = new AllIntroButton(this); // Here we pass IntroFrame class into AllIntroButton class . So that we can get Action Listener

        containpain.add(allIntroButton, BorderLayout.NORTH); // Here we set button layout 

        containpain.add(jlable2 = new JLabel("Developed By : SOMPOD "), BorderLayout.CENTER);
        containpain.add(jlable1 = new JLabel("Date : 05/05/2018"), BorderLayout.SOUTH);

        setVisible(true); // This method for we can see the jframe

    }

    @Override
    public void actionPerformed(ActionEvent e) { // when we press any button then call this  method 

        if (e.getActionCommand().equals("Play")) { // if we press play button 

            SpecialFighter sp = new SpecialFighter(); // Here create SpecialFighter class object and doing her work ;) 
            this.setVisible(false); // And Here IntroFrame class gone closed.
        }
        if (e.getActionCommand().equals("Option")) { // If we pressed Option button 
            JOptionPane.showMessageDialog(createRootPane(), " Next Update!!!"); // Here shown popup menu 
        }
    }

    public static void main(String[] args) {
        new IntroFrame(); // Here this class make own object and call herself
    }
}
