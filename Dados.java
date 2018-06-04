/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author juan
 */
@SuppressWarnings("serial")
public class Dados extends JDialog implements ActionListener {

    JLabel lb1, lb2, lbDin, lbPrem;
    JButton btn;
    String[] dado = {"dado1.png", "dado2.png", "dado3.png", "dado4.png", "dado5.png", "dado6.png"};
    double din;
    Timer temp1, temp2, temp3, temp4;
    int cont = 1;

    public Dados(Casino f) {
        super(f);
        din = Double.parseDouble(f.txt.getText());
        this.setLayout(null);

        lbDin = new JLabel("Dinero acumulado: " + din);
        lbDin.setSize(lbDin.getPreferredSize());
        lbDin.setLocation(180, 50);
        add(lbDin);

        lb1 = new JLabel();
        lb1.setSize(lb1.getPreferredSize());
        lb1.setLocation(50, 100);
        add(lb1);

        lb2 = new JLabel();
        lb2.setSize(lb2.getPreferredSize());
        lb2.setLocation(300, 100);
        add(lb2);

        btn = new JButton("Jugar");
        btn.setSize(btn.getPreferredSize());
        btn.setLocation(230, 20);
        btn.addActionListener(this);
        add(btn);

        lbPrem = new JLabel("Premio obtenido:                   ");
        lbPrem.setSize(lbPrem.getPreferredSize());
        lbPrem.setLocation(180, 80);
        add(lbPrem);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (temp1 != null) {
            temp1.stop();
        }
        if (temp2 != null) {
            temp2.stop();
        }
        if (temp3 != null) {
            temp3.stop();
        }
        if (temp4 != null) {
            temp4.stop();
        }
        din -= 1;
        int n, m;
        n = (int) (Math.random() * 6);
        m = (int) (Math.random() * 6);
        if (din > 0) {

            if (ae.getSource() == btn) {
                ImageIcon imag1 = new ImageIcon(Dados.class.getResource(("" + dado[n])));
                lb1.setIcon(imag1);
                lb1.setSize(lb1.getPreferredSize());

                ImageIcon imag2 = new ImageIcon(Dados.class.getResource(("" + dado[m])));
                lb2.setIcon(imag2);
                lb2.setSize(lb2.getPreferredSize());
            }
            if (n == m) {
                if (n == 5) {
                    lbPrem.setText("Premio obtenido: segundo");
                    din += 2;
                    temp1 = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if (cont % 2 == 0) {
                                lbPrem.setForeground(Color.GREEN);
                            } else {
                                lbPrem.setForeground(Color.ORANGE);
                            }
                            cont++;
                        }
                    });
                    temp1.start();
                } else {
                    din += 1;
                    lbPrem.setText("Premio obtenido: tercero");

                    temp2 = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if (cont % 2 == 0) {
                                lbPrem.setForeground(Color.PINK);
                            } else {
                                lbPrem.setForeground(Color.WHITE);
                            }
                            cont++;
                        }
                    });
                    temp2.start();
                }
            } else {
                if (n == 0 && m == 5 || n == 1 && m == 4 || n == 2 && m == 3 || n == 3 && m == 2 || n == 4 && m == 1 || n == 5 && m == 0) {
                    lbPrem.setText("Premio obtenido: primero");
                    temp3 = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if (cont % 2 == 0) {
                                lbPrem.setForeground(Color.BLUE);
                            } else {
                                lbPrem.setForeground(Color.yellow);
                            }
                            cont++;
                        }
                    });
                    temp3.start();
                    din += 20;
                } else {
                    lbPrem.setText("Premio obtenido: ninguno");
                    temp4 = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if (cont % 2 == 0) {
                                lbPrem.setForeground(Color.red);
                            } else {
                                lbPrem.setForeground(Color.GRAY);
                            }
                            cont++;
                        }
                    });
                    temp4.start();
                }
                lbDin.setText("Dinero acumulado: " + din);
            }
        }
    }
}
