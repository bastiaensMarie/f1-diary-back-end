package com.f1diary.f1diary_back_end.Team.Service;

public class TeamServiceException extends Exception {
  public String field;

  public TeamServiceException(String field, String message) {
      super(message);
      this.field = field;
  }

  public String getField() {
    return field;
  }
}
