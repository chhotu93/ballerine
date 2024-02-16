package com.qa.opencart.exception;

import org.testng.annotations.Test;

public class FrameworkException extends RuntimeException {

  public FrameworkException(String mesg) {
    super(mesg);
  }

  @Test
  public void test() {
    try {
      // Provide a meaningful message when creating an instance
      throw new FrameworkException("This is a test exception message");
    } catch (FrameworkException e) {
      // Handle the exception or print the message
      System.out.println("Caught FrameworkException: " + e.getMessage());
    }
  }
}
