/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmsc350project2;

/**
 *
 * @author stephenjones
 */
public class PostfixManipulation<T> {
    //Array for string expression converted to char tokens
    private char [] postfixTokens;
    private int numTokens = 0;
    //Stack that holds expression objects during calculation  
    StackLinkedList<T> assemblyExpression;
    private String operatorString;
    //Stores the registers and their expressions
    private String[] registerNum;
    private int r = 0;
}
