package com.hsenid.scientificCalculator.model;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vidushka on 11/30/16.
 */
public class CalculatorOperatons {
    public double total = 0;
    public String val;
    public double memory = 0;

    public String convertOperand(String input) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d*)?+$");
        Matcher match = pattern.matcher(input);
        match.find();
        String output = match.group();
        return output;
    }

    public void add(String operand) {
        total += Double.valueOf(operand);
    }

    public void multiply(String operand) {
        total *= Double.valueOf(operand);
    }

    public void subtract(String operand) {
        total -= Double.valueOf(operand);
    }

    public void divide(String operand) {
        total /= Double.valueOf(operand);
    }

    public void calculateSin(Double angle) {
        total = Math.sin(angle);
    }

    public void calculateCos(Double angel) {
        total = Math.cos(angel);
    }

    public void calculateTan(Double angel) {
        total = Math.tan(angel);
    }

    public void calculateCosec(Double angel) {
        total = 1 / Math.sin(angel);
    }

    public void calculateSec(Double angel) {
        total = 1 / Math.cos(angel);
    }

    public void calculateCot(Double angel) {
        total = 1 / Math.tan(angel);
    }

    public void calculateSqRoot(String operand) {
        total = Math.sqrt(Double.parseDouble(operand));
    }

    public void getPowerTwo(String operand) {
        total = Math.pow(Double.parseDouble(operand), 2);
    }

    public void getAnyPower(String leftOperand, String rightOperand) {
        total = Math.pow(Double.parseDouble(leftOperand), Double.valueOf(rightOperand));
    }

    public void getInverse(String leftOperand, String rightOperand) {
        total = Math.pow(Double.parseDouble(leftOperand), Double.valueOf(rightOperand) * -1);
    }

    public void getAnyRoot(String leftOperand, String rightOperand) {
        total = Math.pow(Double.parseDouble(rightOperand), 1 / Double.valueOf(leftOperand));
    }

    public void getLogarithm(String operand) {
        total = Math.log10(Double.parseDouble(operand));
    }

    public void getNaturalLog(String operand) {
        total = Math.log(Double.parseDouble(operand));
    }

    public void getAnyBaseLog(double base, String operand) {
        total = Math.log(Double.parseDouble(operand)) / Math.log(base);
    }

    public void getAntiLog(double base, String operand) {
        total = Math.pow(base, Double.parseDouble(operand));
    }

    public void convertHexToDec(String operand) {
        val = String.valueOf(Integer.parseInt(operand, 16));
    }

    public void convertDecToBin(String operand) {
        val = Integer.toBinaryString(Integer.parseInt(operand));
    }

    /*public void evaluateExp(String expression) {
        //String[] expressionArr = expression.split("(?<=[-+*//*])|(?=[-+*//*])");
        String[] expressionArr = expression.split(".+\\\\(([0-9]+)\\\\).+");
        for (int i = 0; i < expressionArr.length - 1; i++) {
            System.out.println(expressionArr[i]);
        }
    }*/

    public double evaluate(String expression, int d) {
        expression = expression.replaceAll("x", String.valueOf(d));
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();


        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            } else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                if(tokens[i+1] >= '0' && tokens[i+1] <= '9'){
                    StringBuffer collectChars = new StringBuffer();
                    while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '+' || tokens[i] == '-')) {
                        collectChars.append(tokens[i++]);
                    }
                    values.push(Double.parseDouble(collectChars.toString()));
                } else {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                }
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public void memoryOperation(String operand, String operator){
        if (memory == 0 && operator.equals("M+")) {
            memory = Double.parseDouble(operand);
        } else if (memory == 0 && operator.equals("M-")){
            memory = -1 * Double.parseDouble(operand);
        } else if(operator.equals("M+")){
          memory += Double.parseDouble(operand);
        } else if (operator.equals("M-")){
            memory -= Double.parseDouble(operand);
        } else if(operator.equals("clearM")){
            memory = 0;
        }
    }

}

