/*
Filename: InterExpressObjects.java
Author: Stephen Jones
Date: 14NOV2018
Purpose: Project 2 class that defines the objects that represent the 
intermediate as well as final expressions along with the binary operator 
linkning the two sides of the expression.

References used to help create code:


 */
package cmsc350project2;

public class InterExpressObjects {
    
    //Variables
    private String expression = "";
    private String operator = "";
    
    //Constructors
    public InterExpressObjects(){
        
    }
    //For integers with no operators
    public InterExpressObjects(String expression){
        this.expression = expression;
    }
    //For expressions and operators
    public InterExpressObjects(String expression, String operator){
        this.expression = expression;
        this.operator = operator;
    }
    //For objects popped from Stack
    public InterExpressObjects(InterExpressObjects object){
        expression = object.getExpression();
        operator = object.getOperator();
    }
    
    //Getter and setter methods
    public String getExpression(){
        return expression;
    }
    
    public String getOperator(){
        return operator;
    }
    
    public void setExpression(String newExpression){
            expression = newExpression;
    }
    
    @Override
    public String toString(){
        return expression;
    }
    
}
