/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Habitaciones extends JFrame implements ItemListener {

    JLabel lb;
    JLabel img;
    JComboBox<String> lst;
    String[] hab = {"Individual", "Doble", "Doble con sofá cama", "Suite"};

    public Habitaciones(Casino f) {

        setLayout(new FlowLayout());
        lb = new JLabel("Seleccione el tipo de habitación que desee ver");
        add(lb);

        lst = new JComboBox<String>(hab);
        lst.setMaximumRowCount(4);
        add(lst);

        img=new JLabel("Hola");
        add(img);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource().getClass()==JComboBox.class){
            if(ie.getSource().equals("Doble"))
            img.setText("Doble");
        }
    }

}
