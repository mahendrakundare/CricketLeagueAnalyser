package com.bridgelabz.cricketleague;

public class CricketLeagueException extends Exception {

    enum ExceptionType {
        FILE_PROBLEM,DELIMITER_OR_HEADER_PROBLEM,UNABLE_TO_PARSE
    }
    ExceptionType type;
    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
