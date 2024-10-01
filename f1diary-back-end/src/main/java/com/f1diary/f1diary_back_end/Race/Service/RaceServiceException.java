package com.f1diary.f1diary_back_end.Race.Service;

public class RaceServiceException extends Exception{
    private String field;

    public RaceServiceException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
