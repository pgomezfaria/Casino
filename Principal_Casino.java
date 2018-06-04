/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;
import javax.swing.JFrame;
/**
 *
 * @author juan
 */
public class Principal_Casino {
    public static void main(String[] args) {
        
    Casino llamar = new Casino();
    llamar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    llamar.setSize(600,600);
    llamar.setLocation(400,100);
    llamar.setVisible(true);
    }
}
