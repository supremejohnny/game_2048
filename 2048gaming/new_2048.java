/**
 * Author: Johnny Gan
 * Revised: April 7, 2021
 *
 * Description: The class for creating the playing
 * window so that the contents could be added to the
 * main window.
 */

package src;
import src.mainpanel;

import javax.swing.*;
import java.awt.*;


/**
 * @brief The class for creating the main playing window.
 * @detail The main class that creates the window's position
 * and boundings. The set up of the window is important because
 * the panels and the contents are added to the main window.
 */
public class new_2048 extends JFrame {


    /**
     * @brief The class for setting the sizes and positions
     */
    public new_2048(){
        super();
        setBounds(260,100,400,520);
        getContentPane().setBackground(Color.PINK);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("                             !2048!");
        JPanel jp_p = new JPanel();
        JLabel jp = new JLabel("Happy 2048!", JLabel.CENTER);
        jp.setBorder(BorderFactory.createEtchedBorder());
        jp.setForeground(Color.white);
        jp.setFont(new Font("",Font.BOLD,30));
        jp_p.setBackground(Color.PINK);
        jp_p.setBounds(40,0,300,60);
        jp_p.add(jp);
        this.add(jp_p);

        mainpanel a = new mainpanel();
        this.add(a);



    }

}
