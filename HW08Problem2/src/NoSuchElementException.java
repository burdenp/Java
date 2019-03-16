// Assignment 8 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

//copied code from problem one that inclueds answer to problem 2
//since they are both from the same lab and use
//all the same classes

/**
 * Copyright 2007, 2008, 2012 Viera K. Proulx
 * This program is distributed under the terms of the 
 * GNU Lesser General Public License (LGPL)
 */

/**
 * Exception to be raised when the desired item does not exist.
 * 
 * @author Viera K. Proulx
 */
public class NoSuchElementException extends RuntimeException {

  /**--*/
  private static final long serialVersionUID = 3990453678693279717L;
  
  /**
   * Constructs a new exception with null as its detail message.
   */
  public NoSuchElementException() {
    super();
  }

  /**
   * Constructs a new exception with the specified detail message.
   * 
   * @param message the error message
   */
  public NoSuchElementException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception with the specified detail message and cause.
   * 
   * @param message the error message
   * @param cause the cause for the message
   */
  public NoSuchElementException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new exception with the specified cause and a detail message.
   * 
   * @param cause the cause for the message
   */
  public NoSuchElementException(Throwable cause) {
    super(cause);
  }

}
