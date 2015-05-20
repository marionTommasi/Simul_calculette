package com.example.wizar_000.simul_calculette;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import constant.enum_calculation_digit;
import constant.enum_feedback;

/**
 * Created by wizar_000 on 19/05/2015.
 */
public class CalculationModule {

    private double result;
//    private static Stack inputStack;//stack storing the input
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
        add('N');
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
    private static final char EMPTY = 'E';
//    private static final char INVALIDINPUT = 'F';

    //Static field
//    private static final int lastInputIsOperand = 0;
//    private static final int lastInputIsOperator = 1;
//    private static final int lastInputIsOK = 2;
//
//
//    public void resetLastInput() {
//        this.lastInput = -1;
//    }
//
//    //Last input pointer; Backspace and OK not included
//    private int lastInput = -1;

//    private boolean IsResultGetsIntoCalculation = false;
    private String tempOperand = null;//Current forging operand

    private void setLastChar(char lastChar) {
        this.lastChar = lastChar;
    }

    private void resetLastChar(){
        this.lastChar = Character.MIN_VALUE;
    }

    private char lastChar; // last input char
    private ArrayList<Double> operandList; // Premier operands arraylist without calculation priority
    private ArrayList<Character> operatorList;//Premier operator arraylist without calculation priority



    /**
     * Getter of Result
     * @return
     */
    public double getResult() {
        return result;
    }


    /**
     * Constructor of the class
     */
    public CalculationModule(){
        operands = new double[0];
//        inputStack = new Stack();
        result = 0.0;
        calculatorState = CALCULATORSTATE.ON_ENTERING;
        operandList = new ArrayList<Double>();
        operatorList = new ArrayList<Character>();
    }

    /**
     * Public interface opened to outer caller
    * Called by main calculator
    * Handle all kind of input passed by caller
    * @arg permitted in valideOperatingInput
    * @Return false if a non-valid input
     */
    public enum_feedback GetInput(char arg){

        if (!valideOperatingInput.contains(arg))
            return enum_feedback.INVALID_INPUT;
        else if (lastChar == OK && arg == OK)
            return enum_feedback.REQUEST_RESULT;
        else if (arg == OK){
            Calculate();
            return enum_feedback.VALID_INPUT;
        }else if (arg == BACKSPACE){
            handleBackspace();
            return enum_feedback.VALID_INPUT;
        }

        switch (calculatorState){
            case JUST_RESULT_OUT:
                calculatorState = CALCULATORSTATE.ON_ENTERING;
                if (OPERANDS.contains(arg)){ // if we just got the result and enter a digit,the calculator will relaunch a new round
                    String temp = Character.toString(arg);
                    if (temp.equals(enum_calculation_digit.N.toString()))
                        tempOperand = "0.";
                    else tempOperand = temp;
                }else if(OPERATORS.contains(arg)){
                    operatorList.add(arg);//Push the operator into operator list
                    operandList.add(result); // Push the last result into operand list
                }
                lastChar = arg; // set last input flag
                break;
            case ON_ENTERING:
                CheckInput(arg);
                break;
        }
        return enum_feedback.VALID_INPUT;
    }

//    private void onEntering(char arg) {
//        switch (arg){
//            case OK:         //If "OK" detected, launch the calculation.Return the value.
//                Calculate();
//                break;
//            case BACKSPACE: //If "Backspace" detected, launch the deleting handler
//                inputStack.pop();
//                break;
//            default: inputStack.push(arg); //Otherwise, push the current input into stack
//                break;
//        }
//    }


    /*
    Triggered when Backspace button clicked
    Handle deleting
     */
    private void handleBackspace() {
        if (OPERANDS.contains(lastChar) ){
            if ( tempOperand.isEmpty() && !operandList.isEmpty()) {
                String tempS = operandList.get(operandList.size()-1).toString();
                tempS = tempS.substring(0,tempS.length()-1);

                if (tempS.isEmpty() || tempS.equals("-")){ // if there remains just the negative sigh, remove this element.
                    operandList.remove(operandList.size()-1);
                }

                try{
                    double tempD = Double.parseDouble(tempS);
                    operandList.set(operandList.size()-1,tempD);
                }catch (NumberFormatException e){
                    Log.e("DoubleExcption","double parse exception");
                }

            }else if (tempOperand.isEmpty()&& operandList.isEmpty()){
                Log.e("DeleteError","tempOperand null and operandList null");
            }else{
                tempOperand = tempOperand.substring(0,tempOperand.length()-1);//trim the last element
            }
        }else if (OPERATORS.contains(lastChar) && !operatorList.isEmpty()){
            operatorList.remove(operatorList.size()-1);
        }else Log.e("DeleteError","Last element null deleting exception!");
    }


    //
    /*
    Triggered when "OK" pressed,
    calculate the formula and return the result
     */
    private double Calculate() {
        //TODO

        ArrayList<Integer> CalSignQueue = sortSignIndex();
        result = operandList.get(CalSignQueue.get(0));
        Iterator<Character> calculIterator = operatorList.iterator();
        for (char sign = calculIterator.next(); calculIterator.hasNext();calculIterator.next()){
            //TODO
        }
        calculatorState = CALCULATORSTATE.JUST_RESULT_OUT;
        operandList.clear();
        operatorList.clear();
        return result;
    }

    private ArrayList<Integer> sortSignIndex() {

//        for (Iterator iterator = operatorList.iterator();iterator.hasNext();iterator.next()){
//        }
        ArrayList<Integer> orderedOperatorArray = new ArrayList<>();
        ArrayList<Character> tempOperatorList = operatorList;
        boolean sortNotFinish = true;
        int num = 0;
        while(sortNotFinish){
            int flagCounter = 0;
            char tempSign = tempOperatorList.get(flagCounter);
            while(flagCounter<tempOperatorList.size() && (tempSign != '*' || tempSign != '/')){
                flagCounter++;
                tempSign = tempOperatorList.get(flagCounter);
            }
            if (flagCounter != tempOperatorList.size() && (tempSign == '*' || tempSign == '/')){
                orderedOperatorArray.remove(flagCounter);
                orderedOperatorArray.add(flagCounter)  ; //Put this operator index into the first
                tempOperatorList.set(flagCounter, '0'); //Remove this operator index from the array
                num++;
            }else if (flagCounter == tempOperatorList.size())
                sortNotFinish = false;
        }
        for (int i=0;i<operatorList.size()-num;i++){ // Operator index order
            orderedOperatorArray.add(i);
        }
        return orderedOperatorArray;
    }



    /**
     * Check the input type: operand or operator
     * If operand, put the passed digit into a temporary charset
     * Detect the decimal point and trim the extra digit or extra decimal point after two decimals
     * Reassemble the operand from the charset if a operator detected after a series of digits
     * Inverse the negativity of the operand every time if a negative sign entered
     * The negativity between two operators should not be taken into consideration
     * Erase the precedent operator and replace with the current entering operator if a consecutive operator entered
     * @param currentChar
     */
    private void CheckInput(char currentChar){
//       boolean inputValide = true;
        String currentInput = Character.toString(currentChar);

        if (lastChar == EMPTY){

            if (OPERANDS.contains(currentChar)){
                tempOperand = currentInput;
                lastChar = currentChar;
            }else return;
        }else {
            if (OPERANDS.contains(currentChar)){
                if (currentInput.equals(enum_calculation_digit.N.toString())){ // Negativity sign key
                    XORNegativity(currentInput);
                }else if (currentInput.equals(enum_calculation_digit.SIGN_DECIMAL_POINT.toString())){
                    //Decimal point key input
                    if (!tempOperand.contains(".")) // If there are already a decimal sign, ignore it.
                        tempOperand = tempOperand.concat(currentInput);

                }else {
                    if (tempOperandDecimalsFull())
                        return;
                    tempOperand = tempOperand.concat(currentInput);
                }
                lastChar = currentChar;
            }else if (OPERATORS.contains(currentChar)){
                if (operandList.isEmpty() && tempOperand.isEmpty())
                    return;

                if ( OPERANDS.contains(lastChar) && !tempOperand.equals("-") && !tempOperand.equals(".")) {
                    operandList.add(Double.parseDouble(tempOperand)); // Current operand pushed
                    tempOperand = ""; // Current operand flag cleared
                    operatorList.add(currentChar); // Current operator pushed
                    }else if (OPERATORS.contains(lastChar)){
                    operatorList.set(operatorList.size()-1, currentChar);
                }
                lastChar = currentChar;
            }
        }
//        return inputValide;
    }

    /**
     * Detect if there are two decimals
     * @return
     */
    private boolean tempOperandDecimalsFull() {
        String[] operandSet = tempOperand.split(".");
        if (operandSet[1].length() >= 2)
            return true;
        return false;
    }

    /**
     * xor the operand negative sign
     * Negative sign is a specific button in the MIGICA BOX keyboard
     * Which represents the negativity inversion of the current operand
     * @param negaSign
     */
    private void XORNegativity(String negaSign) {

        if (tempOperand.isEmpty()){
            tempOperand = negaSign;// If temp operand is null, the first negative sign entering means pass it to negative
        }else {
//            double tempD = Double.parseDouble(tempOperand);
//            String currentNegativity = tempD < 0 ? "-":"+";
            if (!tempOperand.equals(negaSign))
                tempOperand = "-";
        }

    }


    /**
    *Trim the extra digits after two decimals
    *Remove "," between the two decimals
    *Add a "0" before a decimals input like ",58"
     */
    public double FormalizeOperand(double operand){
        double formalizedOpe = 0;
        //TODO
        return formalizedOpe;
    }
}
