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
