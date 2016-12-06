package con.hsenid.scientificCalculator.view;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by ${Vidushka} on 11/30/16.
 */
public class calculator extends JFrame{
    private JPanel panel1;
    private JButton btn9;
    private JButton btn8;
    private JButton btn7;
    private JButton btn6;
    private JButton btn5;
    private JButton btn4;
    private JButton btn3;
    private JButton btn2;
    private JButton btn1;
    private JButton btn0;
    private JButton btnDot;
    private JButton btnPresentage;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnSubstract;
    private JButton btnAdd;
    private JTextArea calDisplay;

    public calculator() {
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "9");
            }
        });
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "8");
            }
        });
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "7");
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "6");
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "5");
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "4");
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "3");
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "2");
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "1");
            }
        });
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "0");
            }
        });
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + ".");
            }
        });
        btnPresentage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "%");
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "/");
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "*");
            }
        });
        btnSubstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "-");
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "9");
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "+");
            }
        });
    }
}
