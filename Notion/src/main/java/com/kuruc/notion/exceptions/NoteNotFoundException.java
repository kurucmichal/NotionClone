package com.kuruc.notion.exceptions;

public class NoteNotFoundException extends Exception{
  public NoteNotFoundException() {
    super();
  }

  public NoteNotFoundException(String message) {
    super(message);
  }
}
