package com.hsenid.scientificCalculator.view;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vidushka on 12/7/16.
 */
public class ExpPlotter extends JFrame {
    CalculatorOperatons operatons = new CalculatorOperatons();
    Calculator calc = new Calculator();
    private JPanel plotterWindow;

    public ExpPlotter() {
        add(new Draw());
    }

    class Draw extends JPanel {
        Calculator cal = new Calculator();

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = -250;
            double y = 0;
            Polygon p = new Polygon();
            String expression = calc.expression;
            while (-250 <= x && x <= 250) {
                y = operatons.evaluate(expression, x);
                p.addPoint(150 + x, 300 - (int) y);
                x++;
            }
            g.setColor(Color.blue);
            g.drawPolyline(p.xpoints, p.ypoints, 501);
            g.setColor(Color.black);
            g.drawLine(0, 150, 600, 150);
            g.drawLine(300, 0, 300, 300);

            for (int i = 20; i < 300; i += 20) {
                g.drawLine(295, i, 300, i);
            }

            for (int i = 20; i < 600; i += 20) {
                g.drawLine(i, 155, i, 150);
            }

            g.drawLine(290, 10, 300, 0);
            g.drawLine(310, 10, 300, 0);
            g.drawLine(590, 140, 600, 150);
            g.drawLine(590, 160, 600, 150);

            g.drawString("20", 275, 145);
            g.drawString("20", 315, 170);
            g.drawString("X", 280, 15);
            g.drawString("Y", 580, 130);

        }
    }

    public void generatePlot(ExpPlotter frame) {
        frame.setSize(600, 300);
        frame.setTitle("Plotter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
