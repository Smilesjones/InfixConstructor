/*
Filename: ThreeAddressGenerate.java
Author: Stephen Jones
Date: 14NOV2018
Purpose: Project 2 class that converts the postfix expression string to a 
certain number 3 address instructions and can output the instruction as a
txt file.

References used to help create code:
    Elizes, R. (2018, November 9). Week 3 – Postfix Expressions and A Simple 
Algorithm. Retrieved November 15, 2018, from 
https://learn.umuc.edu/d2l/le/news/330288/1338629/view


 */
package cmsc350project2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ThreeAddressGenerate {
    //Array for string expression converted to char tokens
    private char [] expressionTokens;
    private int numTokens = 0;
    //Expression objects
    InterRegisterObjects leftExp, rightExp, newExp, number;
    //Stack that holds expression objects during calculation  
    StackLinkedList<InterRegisterObjects> assemblyExpression;
    private String operatorString;
    //Stores the registers and their expressions
    private String[] registerNum;
    private int r = 0;

    
    //Constructor
    public ThreeAddressGenerate (String postfixInput) throws NoSuchElementException{
        expressionTokens = postfixInput.trim().toCharArray();
        numTokens = expressionTokens.length;
        //Create register array, stack linked list, and expression objects
        registerNum = new String[numTokens/2];
        assemblyExpression = new StackLinkedList<>();
        rightExp = new InterRegisterObjects();
        leftExp = new InterRegisterObjects();
    }
    public ThreeAddressGenerate(){
        
    }
    
    //Methods
    public void generateThreeAddress() throws NoSuchElementException, NumberFormatException{
        String currentToken = "";
        int size = expressionTokens.length;
        
        
        for (int i = 0; i < size; i++){
            
            //Convert tokens to strings
            currentToken = Character.toString(expressionTokens[i]);
            
            //Continue with next token if there is a space
            if (currentToken.equals(" ")){
                continue;
            }
            
            if (currentToken.equals("+")||currentToken.equals("-")||
                    currentToken.equals("*")||currentToken.equals("/")){
                
                //Convert operator symbols to words
                convertOpSymbolToWord(currentToken);
                
                //Pop expression from stack
                rightExp = new InterRegisterObjects(assemblyExpression.pop());
                leftExp = new InterRegisterObjects(assemblyExpression.pop());
                
                //Convert expressions to register reference
                assignRegister(rightExp);
                assignRegister(leftExp);
                
                //Create new object with left and right expressions, operator, 
                //and register
                newExp = new InterRegisterObjects(operatorString +  "  R"+ r + 
                        "  " + leftExp + "  " + rightExp, currentToken,"R"+r);
                
                //Store new expression in register array
                registerNum[r] = newExp.toString();
                r++;
                
                //Push new expression on stack
                assemblyExpression.push(newExp);
                
            }else{//Adding an integer to the stack
                int numCheck = Integer.parseInt(currentToken);
                number = new InterRegisterObjects(currentToken);
                assemblyExpression.push(number);
            }
        }
    }
    
    //Converts operator token symbol to appreviated word 
    public void convertOpSymbolToWord(String op){
        switch (op){
            case "+": operatorString = "Add";
                                break;
            case "-": operatorString = "Sub";
                                break;
            case "*": operatorString = "Mul";
                                break;
            case "/": operatorString = "Div";
                                break;
        }
    }
    
    //Changes expression to register number reference
    public void assignRegister(InterRegisterObjects object){
        if (!object.getRegister().equals("")){
            object.setExpression(object.getRegister());
        }
    }
    
    //Creates txt file with 3 address report
    public void create3AddressReport() throws FileNotFoundException{
        
            PrintWriter output = new PrintWriter("3AddressFile.txt");
            for (int k = 0; k < r;k++){
                System.out.println(registerNum[k].toString());
                output.println(registerNum[k]);
            }
            output.close();
    }
}
