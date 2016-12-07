package com.hsenid.scientificCalculator.view;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${Vidushka} on 12/7/16.
 */
public class ExpPlotter extends JFrame {
    CalculatorOperatons operatons = new CalculatorOperatons();
    Calculator calc = new Calculator();
    private JPanel plotterWindow;

    public ExpPlotter() {
        add(new Draw());
    }

    class Draw extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 0;
            int y = 0;
            Polygon p = new Polygon();
            String expression = calc.expression;
            while (0 <= x && x <= 500) {
                y = operatons.evaluate(expression, x);
                p.addPoint(x, y);
                x++;
            }
            g.setColor(Color.blue);
            g.drawPolyline(p.xpoints, p.ypoints, x);
            g.setColor(Color.black);
            g.drawLine(0, 100, 400, 100);
            g.drawLine(200, 0, 200, 200);

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
