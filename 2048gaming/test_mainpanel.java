/**
 * Author: Johnny Gan
 * Revised: April 7, 2021
 *
 * Description: The test cases for mainpanel.
 */
package src;
import org.junit.Test;

import javax.swing.*;
import src.mainpanel;
import src.operations;
import static org.junit.Assert.*;

public class test_mainpanel {

    @Test
    public void testBlank(){
        assert true;
    }

    @Test
    public void testTexts(){
        mainpanel a = new mainpanel();
        int n = 0;
        for (JLabel[] ele : a.Texts){
            for (JLabel ele2 : ele){
                if (ele2.getText().equals("2")){
                    n++;
                }
            }
        }
        assert n == 2;
    }

    @Test
    public void testCreate(){
        mainpanel a = new mainpanel();
        a.plus_2();
        a.plus_2();
        assert a.remain == 12;
    }

    @Test
    public void testOperation_left(){
        mainpanel a = new mainpanel();
        a.Texts[0][0].setText("2");
        a.Texts[1][0].setText("2");
        new operations().move_left(a.Texts,a.remain);
        assert a.Texts[0][0].getText().equals("4");
    }

    @Test
    public void testOperation_left2(){
        mainpanel a = new mainpanel();
        a.Texts[0][0].setText("8");
        a.Texts[1][0].setText("2");
        new operations().move_left(a.Texts,a.remain);
        assert a.Texts[0][0].getText().equals("8");
    }

    @Test
    public void testOp_right(){
        mainpanel a = new mainpanel();
        a.Texts[2][0].setText("4");
        a.Texts[3][0].setText("4");
        new operations().move_right(a.Texts,a.remain);
        assert a.Texts[3][0].getText().equals("8");
    }

    @Test
    public void testOp_right2(){
        mainpanel a = new mainpanel();
        a.Texts[2][0].setText("2");
        a.Texts[3][0].setText("256");
        new operations().move_right(a.Texts,a.remain);
        assert a.Texts[3][0].getText().equals("256");
    }

    @Test
    public void testOp_down(){
        mainpanel a = new mainpanel();
        a.Texts[0][2].setText("8");
        a.Texts[0][3].setText("8");
        new operations().move_down(a.Texts,a.remain);
        assert a.Texts[0][3].getText().equals("16");
    }

    @Test
    public void testOp_down2(){
        mainpanel a = new mainpanel();
        a.Texts[0][1].setText("2");
        a.Texts[0][2].setText("4");
        a.Texts[0][3].setText("4");
        new operations().move_down(a.Texts,a.remain);
        assert a.Texts[0][2].getText().equals("2");
    }

    @Test
    public void testOp_up(){
        mainpanel a = new mainpanel();
        a.Texts[1][0].setText("16");
        a.Texts[1][1].setText("16");
        new operations().move_up(a.Texts,a.remain);
        assert a.Texts[1][0].getText().equals("32");
    }

    @Test
    public void testOp_up2(){
        mainpanel a = new mainpanel();
        a.Texts[1][0].setText("32");
        a.Texts[1][1].setText("16");
        new operations().move_up(a.Texts,a.remain);
        assert a.Texts[1][0].getText().equals("32");
    }


}
