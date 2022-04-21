/*
Filename: PostfixToInfixConv.java
Author: Stephen Jones
Date: 14NOV2018
Purpose: Project 2 class that converts the postfix expression string to char type
tokens and processes them to create an infix expression representative of the 
original postfix expression.

References used to help create code:

    Elizes, R. (2018, November 9). Week 3 – Postfix Expressions and A Simple 
Algorithm. Retrieved November 15, 2018, from 
https://learn.umuc.edu/d2l/le/news/330288/1338629/view


 */
package cmsc350project2;

public class PostfixToInfixConv {
    //Variables
    //Array of tokens from postfix expression input
    private char [] postfixTokens;
    private int numTokens = 0;
    private String currentToken;
    //Expression objects
    private InterExpressObjects leftExp, rightExp, newExp, number;
    //Linked list stack that holds expression objects
    private StackLinkedList<InterExpressObjects> infixExpression;
    
    //Constructor
    public PostfixToInfixConv (String postfixInput){
        postfixTokens = postfixInput.trim().toCharArray();
        numTokens = postfixTokens.length;
        //Create new objects for stack and expressions
        infixExpression = new StackLinkedList();
        rightExp = new InterExpressObjects();
        leftExp = new InterExpressObjects();
        newExp = new InterExpressObjects();
    }
    //Empty constructor 
    public PostfixToInfixConv(){
    }
    
    //Methods
    public String convertPostfixToInfix() throws NoSuchElementException, NumberFormatException {
       
        for (int i = 0; i < numTokens; i++){
            
            //Convert char tokens to string
            currentToken = Character.toString(postfixTokens[i]);
            //If token is a space, continue to the next token
            if(currentToken.equals(" ")){
                continue;
            }
            
            if (currentToken.equals("+")||currentToken.equals("-")||
                    currentToken.equals("*")||currentToken.equals("/")){
                
                //Create new right and left expression objects from stack
                rightExp = new InterExpressObjects(infixExpression.pop());
                leftExp = new InterExpressObjects(infixExpression.pop());
                
                //Call addParentheses to add parentheses around expressions
                addParentheses(rightExp);
                addParentheses(leftExp);
                
                //Instantiate new expression from left and right expressions
                //and operator, and assign operator
                newExp = new InterExpressObjects((leftExp.getExpression() + 
                        currentToken + rightExp.getExpression()), currentToken);
                
                //Push new expression object to stack
                infixExpression.push(newExp);
                
            }else{//Integers
                int numCheck = 0;
                //Will throw NumberFormatException if not an integer
                numCheck = Integer.parseInt(currentToken);
                number = new InterExpressObjects(currentToken);
                infixExpression.push(number);
            }
        }
        return newExp.toString();
    }
    
    public void addParentheses(InterExpressObjects anExpression){
        String tempExp = "";
        //If there is a value (-,+,*,/) assigned to the operator
        if (!anExpression.getOperator().equals("")){
                tempExp = anExpression.getExpression();
                //Wrap expression in parentheses to ensure order of operations
                anExpression.setExpression("(" + tempExp + ")");
        } 
    }
    //Getter used in try/catch for NumberFormatException to ID problem token
    public String getCurrentToken(){
        return currentToken;
    }
}
