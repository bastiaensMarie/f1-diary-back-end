package com.f1diary.f1diary_back_end.RaceResult.Service;

public class RaceResultServiceException extends Exception {
    public String field;

    public RaceResultServiceException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
