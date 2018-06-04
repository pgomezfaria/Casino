/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author juan
 */
@SuppressWarnings("serial")
public class Reservas extends JDialog{
    
    JComboBox<String> resDia;
    String[] dia={};
    int dias=1;
    JComboBox<Integer> resAño;
    int[] año={2018,2019,2020};
    public Reservas(Casino f){
        
        super(f);
        this.setLayout(null);
        

        
        resDia = new JComboBox<String>(dia);
        resDia.setMaximumRowCount(4);
        resDia.setSize(resDia.getPreferredSize());
        resDia.setLocation(50,50);
        add(resDia);
        
//        resAño = new JComboBox<Integer>(año);
//        resDia.setMaximumRowCount(4);
//        add(resDia);
        
    }
}
