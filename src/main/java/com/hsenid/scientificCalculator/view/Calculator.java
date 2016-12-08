package com.hsenid.scientificCalculator.view;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;

/**
 * Created by Vidushka on 11/30/16.
 */
public class Calculator extends JFrame {
    static String leftOperand;
    static String rightOperand;
    static String operand;
    public static String operator = "no";
    static Double base;
    static String convertOpt;
    public static String expression;
    boolean exp = false;
    CalculatorOperatons op = new CalculatorOperatons();

    private JPanel calPanel;
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
    private JTextField outputDisplay;
    private JButton btnSin;
    private JButton btnCos;
    private JButton btnTan;
    private JButton btnCossec;
    private JButton btnSec;
    private JButton btnCot;
    private JButton btnLog;
    private JButton btnLn;
    private JButton btnInverse;
    private JButton btnMC;
    private JButton btnMR;
    private JButton btnClear;
    private JButton btnEqual;
    private JButton btnSqRoot;
    private JButton btnX2;
    private JButton btnAnyPower;
    private JButton btnAnyRoot;
    private JButton btnAnyLog;
    private JButton btnAntiLog;
    private JButton btnE;
    private JButton btnEnter;
    private JButton btnConvert;
    private JRadioButton convertHexToDec;
    private JRadioButton convertDecToBin;
    private JButton btnFx;
    private JButton btnLeftBracket;
    private JButton btnRightBrcket;
    private JButton btnPlotter;
    private JButton btnX;
    private JComboBox history;
    private JButton btnMPlus;
    private JButton btnMMinus;

    public Calculator() {
        add(calPanel);

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
                calDisplay.setText(calDisplay.getText() + " % ");
            }
        });

        btnE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "e");
                operator = "antiLogE";
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    top:
                    if (op.total == 0) {
                        op.total = Double.valueOf(calDisplay.getText());
                        outputDisplay.setText(calDisplay.getText());
                    } else {
                        operand = calDisplay.getText();
                        if (operand.equals("0")) {
                            outputDisplay.setText("ERROR : Can't divide by 0 !!");
                            break top;
                        }
                        op.divide(op.convertOperand(operand));
                        outputDisplay.setText(String.valueOf(op.total));
                    }
                }
                calDisplay.setText(calDisplay.getText() + " / ");
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    if (op.total == 0) {
                        op.total = 1;
                    }
                    operand = calDisplay.getText();
                    op.multiply(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                }
                calDisplay.setText(calDisplay.getText() + " * ");
            }
        });

        btnSubstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    if (op.total == 0) {
                        op.total = Double.valueOf(calDisplay.getText());
                        outputDisplay.setText(calDisplay.getText());
                    } else {
                        operand = calDisplay.getText();
                        op.subtract(op.convertOperand(operand));
                        outputDisplay.setText(String.valueOf(op.total));
                    }
                }
                calDisplay.setText(calDisplay.getText() + " - ");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    operator = "+";
                    operand = calDisplay.getText();
                    op.add(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                }
                calDisplay.setText(calDisplay.getText() + " + ");
            }
        });

        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operator.equals("Sin")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateSin(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("Cos")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateCos(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("Tan")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateTan(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("Cosec")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateCosec(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("Sec")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateSec(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("Cot")) {
                    operand = calDisplay.getText();
                    double radians = Math.toRadians(Double.valueOf(op.convertOperand(operand)));
                    op.calculateCot(radians);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("sqRoot")) {
                    operand = calDisplay.getText();
                    op.calculateSqRoot(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("getPowerTwo")) {
                    operand = calDisplay.getText();
                    Pattern pattern = Pattern.compile("^\\d+(\\.\\d*)?+");
                    Matcher match = pattern.matcher(operand);
                    match.find();
                    operand = match.group();
                    op.getPowerTwo(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("anyPower")) {
                    rightOperand = calDisplay.getText();
                    op.getAnyPower(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("inverse")) {
                    rightOperand = calDisplay.getText();
                    op.getInverse(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("anyRoot")) {
                    rightOperand = calDisplay.getText();
                    op.getAnyRoot(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("log")) {
                    operand = calDisplay.getText();
                    op.getLogarithm(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("ln")) {
                    operand = calDisplay.getText();
                    op.getNaturalLog(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("antiLog")) {
                    operand = calDisplay.getText();
                    op.getAntiLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if (operator.equals("anyBaseLog")) {
                    operand = calDisplay.getText();
                    op.getAnyBaseLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem("Log" + "(" + base + ")" + " " + operand + " = " + outputDisplay.getText());
                } else if (operator.equals("antiLogE")) {
                    operand = calDisplay.getText();
                    op.getAntiLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else {
                    outputDisplay.setText(String.valueOf(op.evaluate(calDisplay.getText(), 0)));
                    history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                }
            }
        });

        btnSin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Sin ");
                operator = "Sin";
            }
        });

        btnCos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Cos ");
                operator = "Cos";
            }
        });

        btnTan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Tan ");
                operator = "Tan";
            }
        });

        btnCossec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Cosec ");
                operator = "Cosec";
            }
        });

        btnSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Sec ");
                operator = "Sec";
            }
        });

        btnCot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Cot ");
                operator = "Cot";
            }
        });

        btnSqRoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("√");
                operator = "sqRoot";
            }
        });

        btnX2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "^2");
                operator = "getPowerTwo";
            }
        });

        btnAnyPower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOperand = calDisplay.getText();
                calDisplay.setText(calDisplay.getText() + "^");
                operator = "anyPower";
            }
        });

        btnInverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOperand = calDisplay.getText();
                calDisplay.setText(calDisplay.getText() + "^-");
                operator = "inverse";
            }
        });

        btnAnyRoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOperand = calDisplay.getText();
                calDisplay.setText(calDisplay.getText() + "√");
                operator = "anyRoot";
            }
        });

        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("log ");
                operator = "log";
            }
        });

        btnLn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("ln ");
                operator = "ln";
            }
        });

        btnAntiLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("log^-1  ");
                operator = "antiLog";
            }
        });

        btnAnyLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("log   ");
                operator = "anyBaseLog";
            }
        });

        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operator.equals("antiLog")) {
                    base = Double.valueOf(op.convertOperand(calDisplay.getText()));
                    calDisplay.setText("");
                } else if (operator.equals("antiLogE")) {
                    base = 2.7183;
                    calDisplay.setText("");
                }
                if (operator.equals("anyBaseLog")) {
                    base = Double.valueOf(op.convertOperand(calDisplay.getText()));
                    calDisplay.setText("");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("");
                outputDisplay.setText("");
                op.total = 0;
                operand = null;
                leftOperand = null;
                rightOperand = null;
                convertOpt = null;
                exp = false;
            }
        });

        calPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        btnMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operand = calDisplay.getText();
                operator = "clearM";
                op.memoryOperation(operand,operator);
            }
        });

        btnMR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputDisplay.setText(String.valueOf(op.memory));
            }
        });

        convertHexToDec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertOpt = "hexToDec";
                convertHexToDec.setEnabled(false);
                convertDecToBin.setEnabled(true);
                convertDecToBin.setSelected(false);
            }
        });

        convertDecToBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertOpt = "decToBin";
                convertDecToBin.setEnabled(false);
                convertHexToDec.setEnabled(true);
                convertHexToDec.setSelected(false);
            }
        });

        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (convertOpt.equals("hexToDec")) {
                    operand = calDisplay.getText();
                    op.convertHexToDec(operand);
                    outputDisplay.setText(op.val);
                } else if (convertOpt.equals("decToBin")) {
                    operand = calDisplay.getText();
                    op.convertDecToBin(operand);
                    outputDisplay.setText(op.val);
                }
            }
        });

        btnFx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exp = true;
            }
        });

        btnLeftBracket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + " ( ");
            }
        });

        btnRightBrcket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + " ) ");
            }
        });

        btnPlotter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Plotter curve = new Plotter();
                ExpPlotter curve = new ExpPlotter();
                curve.generatePlot(curve);
                expression = calDisplay.getText();
            }
        });
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "x");
            }
        });
        btnMPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operand = calDisplay.getText();
                operator = "M+";
                op.memoryOperation(operand,operator);
            }
        });
        btnMMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operand = calDisplay.getText();
                operator = "M-";
                op.memoryOperation(operand,operator);
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calculator window = new Calculator();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(750, 375);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
