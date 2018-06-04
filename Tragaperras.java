/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class Tragaperras extends JDialog implements ActionListener {

    JLabel img1;
    JLabel img2;
    JLabel img3;
    JButton jugar;
    JLabel credito;
    double num;
    JLabel premio;
    Timer temp;
    Timer temp2;
    Timer temp3;
    boolean flag = false;
    boolean flag2 = false;
    boolean flag3 = false;
    int cont = 1;

    public Tragaperras(Casino f) {
        num = Double.parseDouble(f.txt.getText());
        this.setLayout(new FlowLayout());

        jugar = new JButton("Jugar");
        jugar.addActionListener(this);
        add(jugar);

        img1 = new JLabel();
        add(img1);

        img2 = new JLabel();
        add(img2);

        img3 = new JLabel();
        add(img3);

        credito = new JLabel("Tiene un credito de: " + num + "€");
        add(credito);

        premio = new JLabel("");
        add(premio);

        Casino h = new Casino();
        h.txt.setText("" + num);
        h.txt.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (flag == true) {
            temp.stop();
        }
        if (flag2 == true) {
            temp2.stop();
        }
        if (flag3 == true) {
            temp3.stop();
        }
        num = num - 1;
        String[] matriz = new String[6];
        matriz[0] = "cerezaTragaperras.png";
        matriz[1] = "darth.jpg";
        matriz[2] = "limon.jpg";
        matriz[3] = "monedas.jpg";
        matriz[4] = "tenis.jpg";
        matriz[5] = "uvas.jpg";
        int n, m, t;
        if (num >= 1) {

            n = (int) (Math.random() * 6);
            m = (int) (Math.random() * 6);
            t = (int) (Math.random() * 6);
            ImageIcon imag1 = new ImageIcon(Tragaperras.class.getResource("" + matriz[n]));
            ImageIcon imag2 = new ImageIcon(Tragaperras.class.getResource("" + matriz[m]));
            ImageIcon imag3 = new ImageIcon(Tragaperras.class.getResource("" + matriz[t]));
            img1.setIcon(imag1);
            img1.setSize(img1.getPreferredSize());

            img2.setIcon(imag2);
            img2.setSize(img2.getPreferredSize());

            img3.setIcon(imag3);
            img3.setSize(img3.getPreferredSize());
            if (matriz[n] == matriz[m] && matriz[n] == matriz[t]) {
                num = num + 10;
                credito.setText("Tiene un credito de: " + num + "€");

                premio.setText("Ha obtenido el primer premio");
                temp2 = new Timer(500, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        flag2 = true;
                        if (cont % 2 == 0) {
                            premio.setForeground(Color.red);

                        } else {
                            premio.setForeground(Color.yellow);

                        }
                        cont++;
                    }
                });
                temp2.start();

            } else if (matriz[n] == matriz[m] || matriz[n] == matriz[t] || matriz[m] == matriz[t]) {
                num = num + 1.5;
                credito.setText("Tiene un credito de: " + num + "€");
                premio.setText("Ha obtenido el segundo premio");
                temp3 = new Timer(500, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        flag3 = true;
                        if (cont % 2 == 0) {
                            premio.setForeground(Color.white);

                        } else {
                            premio.setForeground(Color.ORANGE);

                        }
                        cont++;
                    }
                });
                temp3.start();
            } else {
                credito.setText("Tiene un credito de: " + num + "€");
                //  temp = new Timer(500, this);

                premio.setText("No ha resultado ganador");

                temp = new Timer(500, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        flag = true;
                        if (cont % 2 == 0) {
                            premio.setForeground(Color.blue);

                        } else {
                            premio.setForeground(Color.green);
                        }
                        cont++;
                    }
                });
                temp.start();
            }
        } else {
            if (num == 0.5) {
                credito.setText("Tiene un credito de: 0.5€");
            } else {
                credito.setText("Tiene un credito de 0€");
            }
            premio.setText("Ha perdido su dinero, ludópata");
        }

    }
//    public static void main(String[] args) {
//        Tragaperras llamar = new Tragaperras();
//        llamar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        llamar.setSize(600,300);
//        llamar.setLocation(500,300);
//        llamar.setVisible(true);
//    }
}
