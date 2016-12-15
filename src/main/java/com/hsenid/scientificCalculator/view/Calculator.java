package com.hsenid.scientificCalculator.view;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    static Logger log = LogManager.getLogger(CalculatorOperatons.class.getName());
    static String leftOperand;
    static String rightOperand;
    static String operand;
    static String operator = "no";
    static Double base;
    static String inputBase;
    static String expression;
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
    private JButton btnHex;
    private JButton btnDec;
    private JButton btnOct;
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

        btn9.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "9"));

        btn8.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "8"));

        btn7.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "7"));

        btn6.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "6"));

        btn5.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "5"));

        btn4.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "4"));

        btn3.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "3"));

        btn2.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "2"));

        btn1.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "1"));

        btn0.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "0"));

        btnDot.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "."));

        btnE.addActionListener(e -> {
            calDisplay.setText(calDisplay.getText() + "e");
            operator = "antiLogE";
        });

        btnEqual.addActionListener(e -> {
            try {
                if ("Sin".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateSin(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("Cos".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateCos(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("Tan".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateTan(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("Cosec".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateCosec(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("Sec".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateSec(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("Cot".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateCot(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("sqRoot".equals(operator)) {
                    operand = calDisplay.getText();
                    op.calculateSqRoot(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("getPowerTwo".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getPowerTwo(operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("anyPower".equals(operator)) {
                    rightOperand = calDisplay.getText();
                    op.getAnyPower(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("inverse".equals(operator)) {
                    rightOperand = calDisplay.getText();
                    op.getInverse(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("anyRoot".equals(operator)) {
                    rightOperand = calDisplay.getText();
                    op.getAnyRoot(leftOperand, op.convertOperand(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("log".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getLogarithm(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("ln".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getNaturalLog(op.convertOperand(operand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("antiLog".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getAntiLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("anyBaseLog".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getAnyBaseLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem("Log" + "(" + base + ")" + " " + operand + " = " + outputDisplay.getText());
                } else if ("antiLogE".equals(operator)) {
                    operand = calDisplay.getText();
                    op.getAntiLog(base, operand);
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(operand + " = " + outputDisplay.getText());
                } else if ("fact".equals(operator)) {
                    operand = calDisplay.getText();
                    outputDisplay.setText(String.valueOf(op.getFactorial(operand)));
                } else if (exp) {
                    outputDisplay.setText(String.valueOf(op.evaluate(calDisplay.getText(), 0)));
                    history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                } else if ("nCr".equals(operator)) {
                    rightOperand = op.convertOperand(calDisplay.getText());
                    op.getNcR(Long.parseLong(leftOperand), Long.parseLong(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                } else if ("nPr".equals(operator)) {
                    rightOperand = op.convertOperand(calDisplay.getText());
                    op.getNpR(Long.parseLong(leftOperand), Long.parseLong(rightOperand));
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                } else if ("defaltFileOperation".equals(operator)) {
                    c = calDisplay.getText();
                    calDisplay.setText(outputDisplay.getText());
                    outputDisplay.setText(String.valueOf(op.getAnswer(outputDisplay.getText(), a, b, c)));
                } else if ("db".equals(operator)) {

                } else {
                    op.doBasicOperations(basicOperator, calDisplay.getText());
                    outputDisplay.setText(String.valueOf(op.total));
                    history.addItem(calDisplay.getText() + " = " + outputDisplay.getText());
                    operand = null;
                }
                basicOperator = '=';
            } catch (Exception e1) {
                log.error("Malformed exception.", e1);
                outputDisplay.setText(e1.getMessage());
                e1.printStackTrace();
            }
        });

        btnDivide.addActionListener(e -> {

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
                        log.error("Divide failed.", e1);
                        outputDisplay.setText(e1.getMessage());
                    }
                }
            }
            calDisplay.setText(calDisplay.getText() + " / ");
        });

        btnMultiply.addActionListener(e -> {
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
                    log.error("Multiply failed.", e1);
                    outputDisplay.setText(e1.getMessage());
                }
            }
            calDisplay.setText(calDisplay.getText() + " * ");
        });

        btnSubstract.addActionListener(e -> {
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
                        log.error("Subtraction failed.", e1);
                        outputDisplay.setText(e1.getMessage());
                    }
                }
            }
            calDisplay.setText(calDisplay.getText() + " - ");
        });

        btnAdd.addActionListener(e -> {
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
                    log.error("Addition failed", e1);
                    outputDisplay.setText(e1.getMessage());
                }
            }
            calDisplay.setText(calDisplay.getText() + " + ");
        });

        btnSin.addActionListener(e -> {
            calDisplay.setText("Sin ");
            operator = "Sin";
        });

        btnCos.addActionListener(e -> {
            calDisplay.setText("Cos ");
            operator = "Cos";
        });

        btnTan.addActionListener(e -> {
            calDisplay.setText("Tan ");
            operator = "Tan";
        });

        btnCossec.addActionListener(e -> {
            calDisplay.setText("Cosec ");
            operator = "Cosec";
        });

        btnSec.addActionListener(e -> {
            calDisplay.setText("Sec ");
            operator = "Sec";
        });

        btnCot.addActionListener(e -> {
            calDisplay.setText("Cot ");
            operator = "Cot";
        });

        btnSqRoot.addActionListener(e -> {
            calDisplay.setText("√");
            operator = "sqRoot";
        });

        btnX2.addActionListener(e -> {
            calDisplay.setText(calDisplay.getText() + "^2");
            operator = "getPowerTwo";
        });

        btnAnyPower.addActionListener(e -> {
            leftOperand = calDisplay.getText();
            calDisplay.setText(calDisplay.getText() + "^");
            operator = "anyPower";
        });

        btnInverse.addActionListener(e -> {
            leftOperand = calDisplay.getText();
            calDisplay.setText(calDisplay.getText() + "^-");
            operator = "inverse";
        });

        btnAnyRoot.addActionListener(e -> {
            leftOperand = calDisplay.getText();
            calDisplay.setText(calDisplay.getText() + "√");
            operator = "anyRoot";
        });

        btnLog.addActionListener(e -> {
            calDisplay.setText("log ");
            operator = "log";
        });

        btnLn.addActionListener(e -> {
            calDisplay.setText("ln ");
            operator = "ln";
        });

        btnAntiLog.addActionListener(e -> {
            calDisplay.setText("log^-1  ");
            operator = "antiLog";
        });

        btnAnyLog.addActionListener(e -> {
            calDisplay.setText("log   ");
            operator = "anyBaseLog";
        });

        btnEnter.addActionListener(e -> {
            if ("antiLog".equals(operator)) {
                base = Double.valueOf(op.convertOperand(calDisplay.getText()));
                calDisplay.setText("");
            } else if ("antiLogE".equals(operator)) {
                base = 2.7183;
                calDisplay.setText("");
            }
            if ("anyBaseLog".equals(operator)) {
                base = Double.valueOf(op.convertOperand(calDisplay.getText()));
                calDisplay.setText("");
            }
            if ("defaltFileOperation".equals(operator)) {
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
        });

        btnClear.addActionListener(e -> {
            calDisplay.setText("");
            outputDisplay.setText("");
            op.total = 0;
            operand = null;
            leftOperand = null;
            rightOperand = null;
            basicOperator = '0';
            inputBase = null;
            exp = false;
        });

        calPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        btnMC.addActionListener(e -> {
            operand = calDisplay.getText();
            operator = "clearM";
            basicOperator = 'M';
            op.memoryOperation(operand, operator);
        });

        btnMR.addActionListener(e -> {
            calDisplay.setText(calDisplay.getText() + String.valueOf(op.memory));
            basicOperator = 'M';
        });

        btnFx.addActionListener(e -> exp = true);

        btnLeftBracket.addActionListener(e -> calDisplay.setText(calDisplay.getText() + " ( "));

        btnRightBrcket.addActionListener(e -> calDisplay.setText(calDisplay.getText() + " ) "));

        btnPlotter.addActionListener(e -> {
            ExpPlotter curve = new ExpPlotter();
            curve.generatePlot(curve);
            expression = calDisplay.getText();
        });

        btnX.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "x"));

        btnMPlus.addActionListener(e -> {
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
                log.error("Can not perform M+ ", e1);
                outputDisplay.setText(e1.getMessage());
            }
        });

        btnMMinus.addActionListener(e -> {
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
                log.error("Can not perform M- ", e1);
                outputDisplay.setText(e1.getMessage());
            }
        });

        btnFact.addActionListener(e -> {
            calDisplay.setText("Fact ");
            operator = "fact";

        });

        btnnCr.addActionListener(e -> {
            leftOperand = calDisplay.getText();
            calDisplay.setText(calDisplay.getText() + "C");
            operator = "nCr";
        });

        btnnPr.addActionListener(e -> {
            leftOperand = calDisplay.getText();
            calDisplay.setText(calDisplay.getText() + "P");
            operator = "nPr";
        });

        btnHex.addActionListener(e -> {
            operator = "toHex";
            inputBase = op.getCurrentBase();
            try {
                op.baseConverter(operator, inputBase, calDisplay.getText());
            } catch (Exception e1) {
                outputDisplay.setText("Incorrect " + inputBase + "value");
                log.error("Incorrect " + inputBase + " value", e1);
            }
            outputDisplay.setText(op.val);
        });

        btnDec.addActionListener(e -> {
            operator = "toDec";
            inputBase = op.getCurrentBase();
            try {
                op.baseConverter(operator, inputBase, calDisplay.getText());
            } catch (Exception e1) {
                log.error("Incorrect " + inputBase + " value", e1);
                outputDisplay.setText("Incorrect " + inputBase + " value");
            }
            outputDisplay.setText(op.val);
        });

        btnOct.addActionListener(e -> {
            operator = "toOct";
            inputBase = op.getCurrentBase();
            try {
                op.baseConverter(operator, inputBase, calDisplay.getText());
            } catch (Exception e1) {
                log.error("Incorrect " + inputBase + " value", e1);
                outputDisplay.setText("Incorrect " + inputBase + " value");
            }
            outputDisplay.setText(op.val);
        });

        btnBin.addActionListener(e -> {
            operator = "toBin";
            inputBase = op.getCurrentBase();
            try {
                op.baseConverter(operator, inputBase, calDisplay.getText());
            } catch (Exception e1) {
                log.error("Incorrect " + inputBase + " value", e1);
                outputDisplay.setText("Incorrect " + inputBase + " value");
            }
            outputDisplay.setText(op.val);
        });

        btnSave.addActionListener(e -> {
            String expression1 = calDisplay.getText();
            try {
                if ("history".equals(saveOption)) {
                    PrintWriter out = new PrintWriter(new FileOutputStream(new File("/home/hsenid/Documents/calculatorcalHistory.txt"), true));
                    out.println(history.getSelectedItem());
                    out.close();
                } else if ("defaultFile".equals(saveOption)) {
                    op.saveExpressions(expression1);
                    outputDisplay.setText("Saved to defaultFile");
                } else if ("db".equals(saveOption)) {
                    op.saveToDB(expression1);
                    outputDisplay.setText("Saved to DB");
                }
            } catch (Exception ex) {
                log.error("Save failed", ex);
                ex.printStackTrace();
            }
        });

        btnA.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "a"));

        btnB.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "b"));

        btnC.addActionListener(e -> calDisplay.setText(calDisplay.getText() + "c"));

        viewButton.addActionListener(e -> {
            if ("defaultFile".equals(saveOption)) {
                try {
                    outputDisplay.setText(op.readDefaultFile(new File("/home/hsenid/Documents/calculator/defaultFile.txt")).substring(3));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                operator = "defaltFileOperation";
            } else if ("db".equals(saveOption)) {
                outputDisplay.setText(op.readDB());
            }
        });
        btnDB.addActionListener(e -> {
            operand = "db";
            saveOption = "db";

        });
        btnFile.addActionListener(e -> saveOption = "defaultFile");
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
            log.error("UI load fail", e);
            e.printStackTrace();
        }
        Calculator window = new Calculator();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(750, 340);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}