package com.bridgelabz.cricketleague;

import com.bridgelabz.csvbuilder.CSVBuilderException;

public class CricketLeagueException extends Exception {

    enum ExceptionType {
        FILE_PROBLEM,DELIMITER_OR_HEADER_PROBLEM
    }
    ExceptionType type;

    public CricketLeagueException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
