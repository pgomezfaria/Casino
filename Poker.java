/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author juan
 */
@SuppressWarnings("serial")
public class Poker extends JDialog implements ActionListener{
    
    JButton btnJug;
    JButton btnApos;
    JLabel lbCart1;
    JLabel lbCart2;
    int n,m;
    
    public Poker(Casino f){
        
        super(f);
        this.setLayout(null);
        
        btnJug=new JButton("Juego nuevo");
        btnJug.setSize(btnJug.getPreferredSize());
        btnJug.setLocation(50,80);
        add(btnJug);
        
        btnApos=new JButton("Apostar");
        btnApos.setSize(btnApos.getPreferredSize());
        btnApos.setLocation(50, 120);

        add(btnApos);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnJug){
            n=(int) (Math.random()*11)+1;
        }
    }
}
