
/*
    Bismillahir Rahmanir Rahim
 */
// Am very week in English. so plz don't mind
package AllButton;

// Am very week in English. so plz don't mind
import AllJFrame.IntroFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sompod_Programmer
 */
public class AllIntroButton extends JPanel {

    public AllIntroButton(IntroFrame IF) { // Here we can get Introframe class object . Thats why we can set actionlistener into button
        setLayout(new FlowLayout());
        JButton playbutton = new JButton("Play");
        playbutton.setBounds(60, 50, 20, 30);
        playbutton.addActionListener(IF); // This method call actionlistener
        add(playbutton);

        JButton optionbutton = new JButton("Option");
        optionbutton.setBounds(60, 70, 20, 30);
        optionbutton.addActionListener(IF); // This method call actionlistener
        add(optionbutton);

    }
}
