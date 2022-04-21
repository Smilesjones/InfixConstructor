/*
Filename: InterRegisterObjects.java
Author: Stephen Jones
Date: 14NOV2018
Purpose: Project 2 child class of InterExpressObjects that additionally 
defines registers associated with expressions.

References used to help create code:


 */
package cmsc350project2;


public class InterRegisterObjects extends InterExpressObjects {
    //Variables
    //Variable for the register
    private String register = "";
    
    //Constructors
    //Expression only constructor
    public InterRegisterObjects(String expression){
        super(expression);
    }
    //Expression, operator and register constructor
    public InterRegisterObjects(String expression, String operator, 
            String register){
        super(expression, operator);
        this.register = register;
    }
    //Object constructor
    public InterRegisterObjects(InterRegisterObjects object){
        super(object.getExpression(), object.getOperator());
        this.register = object.getRegister();
    }
    //Empty constructor
    public InterRegisterObjects(){
        
    }
    
    //Methods
    //Getter for the register
    public String getRegister(){
        return register;
    }
    
}
