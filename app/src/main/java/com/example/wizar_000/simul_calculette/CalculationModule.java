package com.example.wizar_000.simul_calculette;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by wizar_000 on 19/05/2015.
 */
public class CalculationModule {

    private double result;
    private static Stack inputStack;//stack storing the input
    private double operands[];//stack storing the operators
    enum CALCULATORSTATE {
        ON_ENTERING,
        JUST_RESULT_OUT
    };
    public CALCULATORSTATE calculatorState;
    private static  ArrayList<Character> valideOperatingInput =
            new ArrayList<Character>(){ {
                add('7');
                add('8');
                add('9');
                add('/');
                add('4');
                add('5');
                add('6');
                add('*');
                add('1');
                add('2');
                add('3');
                add('-');
                add('0');
                add('.');
                add('+');
                add('=');
            }};

    private static ArrayList<Character> OPERANDS = new ArrayList<Character>(){{
        add('7');
        add('8');
        add('9');
        add('4');
        add('5');
        add('6');
        add('1');
        add('2');
        add('3');
        add('0');
        add('.');
    }};
    private static  ArrayList<Character> OPERATORS = new ArrayList<Character>(){{
        add('+');
        add('-');
        add('*');
        add('/');
    }} ;

    //Command area
    private static final char BACKSPACE = 'B';
    private static final char OK = '=';

    //Static field
    private static final int lastInputIsOperand = 0;
    private static final int lastInputIsOperator = 1;
    private static final int lastInputIsOK = 2;

    //Last input pointer; Backspace and OK not included
    private int lastInput;

    private boolean IsResultGetsIntoCalculation = false;

    public double getResult() {
        return result;
    }

    public CalculationModule(Vector<Character> operand){
        operands = new double[0];
        inputStack = new Stack();
        result = 0.0;
        calculatorState = CALCULATORSTATE.ON_ENTERING;
    }

    /*
    Called by main calculator
    Handle all kind of input passed by caller
    *arg permitted in valideOperatingInput
     */
    public void GetInput(char arg){

        if (!valideOperatingInput.contains(arg))
            return;

        switch (calculatorState){
            case JUST_RESULT_OUT:
                if (Character.isDigit(arg)){ // if we just got the result and enter a digit,the calculator will relaunch a new round
                    calculatorState = CALCULATORSTATE.ON_ENTERING;
                    IsResultGetsIntoCalculation = false; // Result doesnot get into calculation
                    inputStack.clear(); // Clear the input stack
                    inputStack.push(arg);
                    break;
                }else if(OPERATORS.contains(arg)){
                    IsResultGetsIntoCalculation = true;
                }
        }
        onEntering(arg);
    }

    private void onEntering(char arg) {
        switch (arg){
            case OK:         //If "OK" detected, launch the calculation.Return the value.
                Calculate();
                break;
            case BACKSPACE: //If "Backspace" detected, launch the deleting handler
                inputStack.pop();
                break;
            default: inputStack.push(arg); //Otherwise, push the current input into stack
                break;
        }
    }


    /*
    Triggered when Backspace button clicked
    Handle deleting
     */
//    private void handleBackspace() {
//    }
//
    /*
    Triggered when "OK" pressed,
    calculate the formula and return the result
     */
    private double Calculate() {
        double result = 0.0;
        double[] operands;
        operands = new double[0];

        for (char element = (char) inputStack.pop();
             !inputStack.empty();element = (char) inputStack.pop()){
            if (Character.isDigit(element)){

            }
        }
        return result;
    }

//    /*
//    Check the validaty of the input
//    Valide input: 0~9,"+","-","*","/",","
//    Otherwise, faulse.
//     */
//    public boolean CheckInput(char input){
//       boolean inputValide = true;
//        return inputValide;
//    }


    /*
    Trim the extra digits after two decimals
    Remove "," between the two decimals
   Add a "0" before a decimals input like ",58"
     */
    public double FormalizeOperand(double operand){
        double formalizedOpe = 0;
        //TODO
        return formalizedOpe;
    }
}
