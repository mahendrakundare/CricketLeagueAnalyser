package com.bridgelabz.cricketleague;

public class CricketLeagueException extends Exception {

    enum ExceptionType {
        FILE_PROBLEM
    }
    ExceptionType type;

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CricketLeagueException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

}
