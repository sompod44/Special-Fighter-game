/*
    Bismillahir Rahmanir Rahim
 */
// Am very week in English. so plz don't mind
package special.fighter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sompod_Programmer
 */
public class Jet {

    Jet(Graphics g, BufferedImage image, int a, int b, GraphicePanel GP) {
        g.drawImage(image, a, b, 100, 100, GP);
    }

}
