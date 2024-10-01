package com.f1diary.f1diary_back_end.Racer.Service;

public class RacerServiceException extends Exception {
    public String field;

    public RacerServiceException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
