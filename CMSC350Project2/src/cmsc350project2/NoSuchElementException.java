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
public class NoSuchElementException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchElementException</code> without
     * detail message.
     */
    public NoSuchElementException() {
    }

    /**
     * Constructs an instance of <code>NoSuchElementException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchElementException(String msg) {
        super(msg);
    }
}
