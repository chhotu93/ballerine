package com.qa.opencart.exception;

import org.testng.annotations.Test;

public class FrameworkException extends RuntimeException {

  public FrameworkException(String mesg) {
    super(mesg);
  }
}
