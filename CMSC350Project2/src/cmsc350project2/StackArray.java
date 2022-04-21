/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

References:

http://cs.lmu.edu/~ray/notes/stacks/
 */
package cmsc350project2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephenjones
 */
public class StackArray implements MyStack {
    //variables for the object array and the number of elements
    private Object[] newStackArray; 
    private int numOfElements = 0;
    
    //stack constructor
    public StackArray(int size){
        newStackArray = new Object[size];
    }
    
    public void push(Object element) {
        if(numOfElements == newStackArray.length){
            throw new IllegalStateException("Stack Array is full");
        }
        newStackArray[numOfElements] = element;
        numOfElements++;
        
    }

    public Object pop() {
        if (numOfElements == 0){
            try {
                throw new NoSuchElementException("Stack Array is Empty");
            } catch (NoSuchElementException ex) {
                Logger.getLogger(StackArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Object poppedElement = newStackArray[numOfElements - 1];
        numOfElements--;
        newStackArray[numOfElements] = null;
        return poppedElement;
    }

    public Object peek() {
        if (numOfElements == 0) {
            try {
                throw new NoSuchElementException("Cannot peek into empty stack");
            } catch (NoSuchElementException ex) {
                Logger.getLogger(StackArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newStackArray[numOfElements - 1];    }

    public int size() {
        return numOfElements;    
    }

    public boolean isEmpty() {
        return numOfElements == 0;    
    }
    
}
