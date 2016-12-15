package com.hsenid.scientificCalculator.view;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vidushka on 11/30/16.
 */
public class Calculator extends JFrame {
    static String leftOperand;
    static String rightOperand;
    static String operand;
    public static String operator = "no";
    static Double base;
    static String inputBase;
    public static String expression;
    boolean exp = false;
    char basicOperator;
    String saveOption;
    String a;
    String b;
    String c;
    boolean currentVariable = false;
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
    private JButton btnFx;
    private JButton btnLeftBracket;
    private JButton btnRightBrcket;
    private JButton btnPlotter;
    private JButton btnX;
    private JComboBox history;
    private JButton btnMPlus;
    private JButton btnMMinus;
    private JButton btnFact;
    private JButton btnnCr;
    private JButton btnnPr;
    private JButton hexButton;
    private JButton btnDec;
    private JButton btnOctg;
    private JButton btnBin;
    private JButton btnSave;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton viewButton;
    private JButton btnDB;
    private JButton btnFile;


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


        btnE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "e");
                operator = "antiLogE";
            }
        });

        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (operator.equals("Sin")) {
                        operand = calDisplay.getText();
                        op.calculateSin(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("Cos")) {
                        operand = calDisplay.getText();
                        op.calculateCos(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("Tan")) {
                        operand = calDisplay.getText();
                        op.calculateTan(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("Cosec")) {
                        operand = calDisplay.getText();
                        op.calculateCosec(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("Sec")) {
                        operand = calDisplay.getText();
                        op.calculateSec(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("Cot")) {
                        operand = calDisplay.getText();
                        op.calculateCot(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("sqRoot")) {
                        operand = calDisplay.getText();
                        op.calculateSqRoot(operand);
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(operand + " = " + outputDisplay.getText());
                    } else if (operator.equals("getPowerTwo")) {
                        operand = calDisplay.getText();
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
                    } else if (operator.equals("fact")) {
                        operand = calDisplay.getText();
                        outputDisplay.setText(String.valueOf(op.getFactorial(operand)));
                    } else if (exp) {
                        outputDisplay.setText(String.valueOf(op.evaluate(calDisplay.getText(), 0)));
                        history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                    } else if (operator.equals("nCr")) {
                        rightOperand = op.convertOperand(calDisplay.getText());
                        op.getNcR(Long.parseLong(leftOperand), Long.parseLong(rightOperand));
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                    } else if (operator.equals("nPr")) {
                        rightOperand = op.convertOperand(calDisplay.getText());
                        op.getNpR(Long.parseLong(leftOperand), Long.parseLong(rightOperand));
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                    } else if (operator.equals("defaltFileOperation")) {
                        c = calDisplay.getText();
                        calDisplay.setText(outputDisplay.getText());
                        outputDisplay.setText(String.valueOf(op.getAnswer(outputDisplay.getText(), a, b, c)));
                    } else if (operator.equals("db")){

                    } else {
                        op.doBasicOperations(basicOperator, calDisplay.getText());
                        outputDisplay.setText(String.valueOf(op.total));
                        history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                        operand = null;
                    }
                    basicOperator = '=';
                } catch (Exception e1) {
                    outputDisplay.setText(e1.getMessage());
                    e1.printStackTrace();
                }
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!exp) {
                    if (op.total == 0 && basicOperator != '/') {
                        op.total = Double.valueOf(calDisplay.getText());
                        outputDisplay.setText(calDisplay.getText());
                    } else {
                        if (basicOperator == '=') {
                            operand = String.valueOf(1);
                        } else {
                            operand = calDisplay.getText();
                        }

                        basicOperator = '/';
                        operator = "/";
                        try {
                            op.doBasicOperations(basicOperator, operand);
                            outputDisplay.setText(String.valueOf(op.total));
                        } catch (Exception e1) {
                            outputDisplay.setText(e1.getMessage());
                        }
                    }
                }
                calDisplay.setText(calDisplay.getText() + " / ");
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    if (op.total == 0 && basicOperator != '*') {
                        op.total = 1;
                    }
                    if (basicOperator == '=') {
                        operand = String.valueOf(1);
                    } else {
                        operand = calDisplay.getText();
                    }
                    basicOperator = '*';
                    operator = "*";
                    try {
                        op.doBasicOperations(basicOperator, operand);
                        outputDisplay.setText(String.valueOf(op.total));
                    } catch (Exception e1) {
                        outputDisplay.setText(e1.getMessage());
                    }
                }
                calDisplay.setText(calDisplay.getText() + " * ");
            }
        });

        btnSubstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    if (op.total == 0 && basicOperator != '-') {
                        op.total = Double.valueOf(calDisplay.getText());
                        outputDisplay.setText(calDisplay.getText());
                    } else {
                        if (basicOperator == '=') {
                            operand = String.valueOf(0);
                        } else {
                            operand = calDisplay.getText();
                        }
                        basicOperator = '-';
                        operator = "-";
                        try {
                            op.doBasicOperations(basicOperator, operand);
                            outputDisplay.setText(String.valueOf(op.total));
                        } catch (Exception e1) {
                            outputDisplay.setText(e1.getMessage());
                        }
                    }
                }
                calDisplay.setText(calDisplay.getText() + " - ");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!exp) {
                    if (basicOperator == '=') {
                        operand = String.valueOf(0);
                    } else {
                        operand = calDisplay.getText();
                    }
                    basicOperator = '+';
                    operator = "+";
                    try {
                        op.doBasicOperations(basicOperator, operand);
                        outputDisplay.setText(String.valueOf(op.total));
                    } catch (Exception e1) {
                        outputDisplay.setText(e1.getMessage());
                    }
                }
                calDisplay.setText(calDisplay.getText() + " + ");
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
                if (operator.equals("defaltFileOperation")) {
                    if (!currentVariable) {
                        a = calDisplay.getText();
                        calDisplay.setText("");
                    }
                    if (currentVariable) {
                        b = calDisplay.getText();
                        calDisplay.setText("");
                    }
                    currentVariable = true;
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
                basicOperator = '0';
                inputBase = null;
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
                basicOperator = 'M';
                op.memoryOperation(operand, operator);
            }
        });

        btnMR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + String.valueOf(op.memory));
                basicOperator = 'M';
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
                if (basicOperator == '=') {
                    operand = outputDisplay.getText();
                } else {
                    operand = calDisplay.getText();
                }
                operator = "M+";
                basicOperator = 'M';
                op.total = 0;
                calDisplay.setText("");
                outputDisplay.setText("");
                try {
                    op.memoryOperation(operand, operator);
                } catch (Exception e1) {
                    outputDisplay.setText(e1.getMessage());
                }
            }
        });

        btnMMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (basicOperator == '=') {
                    operand = outputDisplay.getText();
                } else {
                    operand = calDisplay.getText();
                }
                operator = "M-";
                basicOperator = 'M';
                op.total = 0;
                calDisplay.setText("");
                outputDisplay.setText("");
                try {
                    op.memoryOperation(operand, operator);
                } catch (Exception e1) {
                    outputDisplay.setText(e1.getMessage());
                }
            }
        });

        btnFact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText("Fact ");
                operator = "fact";

            }
        });

        btnnCr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOperand = calDisplay.getText();
                calDisplay.setText(calDisplay.getText() + "C");
                operator = "nCr";
            }
        });

        btnnPr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftOperand = calDisplay.getText();
                calDisplay.setText(calDisplay.getText() + "P");
                operator = "nPr";
            }
        });

        hexButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = "toHex";
                inputBase = op.getCurrentBase();
                try {
                    op.baseConverter(operator, inputBase, calDisplay.getText());
                } catch (Exception e1) {
                    outputDisplay.setText("Incorrect " + inputBase + "value");
                }
                outputDisplay.setText(op.val);
            }
        });

        btnDec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = "toDec";
                inputBase = op.getCurrentBase();
                op.baseConverter(operator, inputBase, calDisplay.getText());
                outputDisplay.setText(op.val);
            }
        });

        btnOctg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = "toOct";
                inputBase = op.getCurrentBase();
                op.baseConverter(operator, inputBase, calDisplay.getText());
                outputDisplay.setText(op.val);
            }
        });

        btnBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = "toBin";
                inputBase = op.getCurrentBase();
                op.baseConverter(operator, inputBase, calDisplay.getText());
                outputDisplay.setText(op.val);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String expression = calDisplay.getText();
                try {
                    if (saveOption.equals("history")) {
                        PrintWriter out = new PrintWriter(new FileOutputStream(new File("/home/hsenid/Documents/calHistory.txt"), true));
                        out.println(history.getSelectedItem());
                        out.close();
                    } else if (saveOption.equals("defaultFile")) {
                        op.saveExpressions(expression);
                        outputDisplay.setText("Saved to defaultFile");
                    } else if (saveOption.equals("db")){
                        op.saveToDB(expression);
                        outputDisplay.setText("Saved to DB");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "a");
            }
        });

        btnB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "b");
            }
        });

        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calDisplay.setText(calDisplay.getText() + "c");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (saveOption.equals("defaultFile")) {
                    try {
                        outputDisplay.setText(op.readDefaultFile(new File("D:/hsenid/defaultFile.txt")).substring(3));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    operator = "defaltFileOperation";
                } else if (saveOption.equals("db")){
                    outputDisplay.setText(op.readDB());
                }
            }
        });
        btnDB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operand = "db";
                saveOption = "db";

            }
        });
        btnFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveOption = "defaultFile";
            }
        });
    }

    public static void main(String[] args) {
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
            }

        } catch (Exception e) {

        }
        Calculator window = new Calculator();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(750, 400);

       /*//String sx = "2 + 50 + 4x";
        //Pattern pattern = Pattern.compile("\\d+(\\.\\d*)?\\w");
        String sx = "2 ";
        Pattern pattern = Pattern.compile("[-+](\\s\\d+(\\.\\d*)?+)?$");
        Matcher match = pattern.matcher(sx);
        match.find();
        String output = match.group();
        System.out.println(output);*/
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}