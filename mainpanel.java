/**
 * Author: Johnny Gan
 * Revised: April 7, 2021
 *
 * Description: The ADT for mainpanel to set up the
 * playing area.
 */
package src;
import src.operations;
import src.new_2048;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @brief The main class to create the main playing panel
 * @details The class is crucial for creating the panel
 * because the playing board is created here and the rules
 * for moving actions are defined here as well.
 */

public class mainpanel extends JPanel{

    public JLabel[][] Texts;
    public int remain = 16;
    public Random rand = new Random();
    public int judge_l, judge_r, judge_u, judge_d;
    public TextField tf; //aux field.
    public JPanel tips_p;
    public JLabel tips;
    public JPanel but_p;
    public JButton but;

    /**
     * @brief The main class to set up the boundings and positions
     */
    public mainpanel(){

        setBackground(Color.PINK);
        setBounds(20, 75, 350, 440);
        setLayout(null);

        tips_p = new JPanel();
        tips_p.setBounds(0,335,340,30);
        tips_p.setBackground(Color.orange);
        tips = new JLabel("Use ↑,↓,←,→ to control! Good luck!");
        tips.setBackground(Color.YELLOW);
        tips.setFont(new Font("",Font.PLAIN,15));
        tips.setBounds(0, 0, 340, 30);
        tips.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        tips_p.add(tips);
        add(tips_p);

        but_p = new JPanel();
        but_p.setBounds(125, 370, 90,40);
        but_p.setBackground(Color.PINK);
        but = new JButton("Try again");
        but.setBorder(BorderFactory.createSoftBevelBorder(0));
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_2048 f = new new_2048();
                f.setVisible(true);
            }
        });
        but_p.add(but);
        add(but_p);


        Texts = new JLabel[4][4];
        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4 ;j++){
                Texts[i][j] = new JLabel();
                Texts[i][j].setBounds(90*i, 85*j, 70 ,70);
                Texts[i][j].setBackground(new Color(243,235,171));
                Texts[i][j].setOpaque(true);
                Texts[i][j].setFont(new Font("",Font.PLAIN,30));
                Texts[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                Texts[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
                //Texts[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                this.add(Texts[i][j]);
            } // for j
        }  // for i
        plus_2();
        plus_2();



        tf = new TextField(15);
        add(tf);
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                Operation(e);
                }
        });

    }


    /**
     * @brief The main function to listen to the keyboard and
     * decide the corresponding moving action according to the
     * input KeyEvent e.
     * @param e, KeyEvent
     */
    private void Operation(final KeyEvent e){
        int k_code = e.getKeyCode();
        switch (k_code){
            case KeyEvent.VK_UP:
                remain = new operations().move_up(Texts, remain);
                judge_u = 1;
                plus_2();
                break;
            case KeyEvent.VK_DOWN:
                remain = new operations().move_down(Texts, remain);
                judge_d = 1;
                plus_2();
                break;
            case KeyEvent.VK_LEFT:
                remain = new operations().move_left(Texts, remain);
                judge_l = 1;
                plus_2();
                break;
            case KeyEvent.VK_RIGHT:
                remain = new operations().move_right(Texts, remain);
                judge_r = 1;
                plus_2();
            default:
                break;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Texts[i][j].getText().equals("2048")) {
                    tips_p.setBackground(Color.YELLOW);
                    tips.setText("!!YOU WIN!!");
                }
            }
        }
    }


    /**
     * @brief The main function to create a 2 in the main
     * playing board and determine if the game is over or not.
     */
    public void plus_2(){  // make a new 2
        int i ,j;
        boolean mark = false;
        String block;

        if(remain > 0){
            while(!mark){
                i = rand.nextInt(4);
                j = rand.nextInt(4);
                block = Texts[i][j].getText();
                if((block.equals(""))){
                    Texts[i][j].setText("2");
                    remain --;
                    mark = true;
                    judge_d = judge_l = judge_r = judge_u = 0;
                }
            }
        } else if(judge_u > 0 && judge_r > 0 && judge_l > 0 && judge_d > 0){    // judges are all 1 so no more 2 created
            tips_p.setBackground(Color.cyan);
            tips.setText("YOU LOSE!");
            but.setText("Try again?");
            but_p.setBackground(Color.red);
        }
    }  // Create 2
}
