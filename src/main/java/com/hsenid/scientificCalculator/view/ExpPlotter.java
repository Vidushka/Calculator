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

            int q = 0;
            double r = 0;
            Polygon p = new Polygon();
                String expression = calc.expression;
                while (0 <= q && q <= 250) {
                    r = operatons.evaluate(expression, q);
                    p.addPoint(q, (int) r);
                    System.out.println("(" + q + " , " + r + ")");
                    q++;
                }
            g.setColor(Color.blue);
            g.drawPolyline(p.xpoints, p.ypoints, 250);
            g.setColor(Color.black);
            g.drawLine(100,50, 500, 50);
            g.drawLine(100, 10, 100, 500);

        }
    }

    public void generatePlot(ExpPlotter frame) {
        frame.setSize(400, 200);
        frame.setTitle("Plotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
