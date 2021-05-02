/**
 * Author: Johnny Gan
 * Revised: April 7, 2021
 *
 * Description: The main class to determine the
 * corresponding moving action according to the
 * input KeyEvent.
 */
package src;
import javax.swing.*;

/**
 * The main class for the rules of moving actions
 */
public class operations {
    int Pre;
    int val;
    String current_block;
    String left_block;
    String right_block;
    String up_block;
    String down_block;

    /**
     * @brief The left moving rule setting
     * @param Texts, seq of seq of JLabel
     * @param remain, Integer
     * @return remain, Integer, modified
     */
    public int move_left(JLabel[][] Texts, int remain){
        for(int j = 0; j < 4; j++){
            Pre = 5;
            for(int k = 0; k < 3; k++){
                for(int i = 1; i < 4; i++){
                    current_block = Texts[i][j].getText();
                    left_block = Texts[i-1][j].getText();

                    if(left_block.equals("")){
                        Texts[i - 1][j].setText(current_block);
                        Texts[i][j].setText("");
                    } else if(current_block.equals(left_block) && i != Pre && i != Pre -1){
                        val = Integer.parseInt(current_block);
                        remain ++;
                        current_block = String.valueOf(val+val);
                        Texts[i - 1][j].setText(current_block);
                        Texts[i][j].setText("");

                        Pre = i;
                    }
                }
            }
        }
        return remain;
    }

    /**
     * @brief The right moving rule setting
     * @param Texts, seq of seq of JLabel
     * @param remain, Integer
     * @return remain, Integer, modified
     */
    public int move_right(JLabel[][] Texts, int remain){
        for(int j = 0; j < 4; j ++){
            Pre = 5;
            for(int m = 0; m < 5; m++){
                for(int i = 2; i >= 0; i--){
                    current_block = Texts[i][j].getText();
                    right_block = Texts[i+1][j].getText();

                    if(right_block.compareTo("") == 0){
                        Texts[i + 1][j].setText(current_block);
                        Texts[i][j].setText("");
                    } else if(current_block.equals(right_block) && i != Pre && i != Pre + 1){
                        val = Integer.parseInt(current_block);
                        remain ++;
                        current_block = String.valueOf(val+val);
                        Texts[i + 1][j].setText(current_block);
                        Texts[i][j].setText("");
                        Pre= i;
                    }
                }
            }
        }
        return remain;
    }

    /**
     * @brief The up moving rule setting
     * @param Texts, seq of seq of JLabel
     * @param remain, Integer
     * @return remain, Integer, modified
     */
    public int move_up(JLabel[][] Texts, int remain){
        for(int i = 0; i < 4;i++){
            Pre = 5;
            for(int j = 0; j < 3;j++){
                for(int k = 1;k < 4;k++){
                    current_block = Texts[i][k].getText();
                    up_block = Texts[i][k-1].getText();

                    if(up_block.compareTo("") == 0){
                        Texts[i][k-1].setText(current_block);
                        Texts[i][k].setText("");
                    } else if ((current_block.equals(up_block)) && (k != Pre) &&( k != Pre-1)) {
                        val = Integer.parseInt(current_block);
                        remain ++;
                        current_block = String.valueOf(val+val);
                        Texts[i][k-1] .setText(current_block);
                        Texts[i][k].setText("");
                        Pre = k;
                    }
                }
            }
        }
        return remain;
    }

    /**
     * @brief The down moving rule setting
     * @param Texts, seq of seq of JLabel
     * @param remain, Integer
     * @return remain, Integer, modified
     */
    public int move_down(JLabel[][] Texts, int remain){
        for(int i = 0; i < 4; i ++){
            Pre = 5;
            for(int k = 0; k < 3; k++){
                for(int j = 2; j >= 0; j--){
                    current_block = Texts[i][j].getText();
                    down_block = Texts[i][j + 1].getText();

                    if(down_block.equals("")){
                        Texts[i][j + 1].setText(current_block);
                        Texts[i][j].setText("");
                    } else if(current_block.equals(down_block) && j !=Pre && j != Pre+ 1){
                        val  = Integer.parseInt(current_block);
                        remain ++;
                        current_block = String.valueOf(val+val);
                        Texts[i][j + 1].setText(current_block);
                        Texts[i][j].setText("");
                        Pre = j;
                    }
                }
            }
        }
        return remain;
    }
}
