/*
Filename: MyStack.java
Author: Stephen Jones
Date: 14NOV2018
Purpose: Project 2 class that defines the stack interface.
 

References used to help create code:

    Stacks. (n.d.). Retrieved November 16, 2018, from 
http://cs.lmu.edu/~ray/notes/stacks/

 */
package cmsc350project2;

public interface MyStack<T> {
    
    void push(T element);
    T pop()throws NoSuchElementException;
    T peek()throws NoSuchElementException;
    int size();
    boolean isEmpty();
    
}
