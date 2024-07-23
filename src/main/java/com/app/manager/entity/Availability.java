package com.app.manager.entity;

public enum Availability {
    AVAILABLE("00", "AVAILABLE"),
    AWAY("05", "AWAY"),
    OFFLINE("90", "OFFLINE");


    private String code;
    private String message;

    Availability(String number, String away) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
