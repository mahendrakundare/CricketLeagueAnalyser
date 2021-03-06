package com.bridgelabz.cricketleague;

public class CricketLeagueException extends Exception {

    public CricketLeagueException(String message, String name) { }

    enum ExceptionType {
        FILE_PROBLEM,DELIMITER_OR_HEADER_PROBLEM,UNABLE_TO_PARSE,NO_DATA
    }
    ExceptionType type;
    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
