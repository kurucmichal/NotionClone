package com.kuruc.notion.exceptions;

public class EventNotFoundException extends Exception {
  public EventNotFoundException() {
    super();
  }

  public EventNotFoundException(String message) {
    super(message);
  }
}
