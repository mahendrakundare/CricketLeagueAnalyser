package com.bridgelabz.cricketleague;

public class CricketLeagueFactory {

    public static CricketLeagueAdapter getClassObject(CricketAnalyser.StatisticCategory category) throws CricketLeagueException {
        if(category.equals(CricketAnalyser.StatisticCategory.BATTING))
            return new BatsmanAdapter();
        else if (category.equals(CricketAnalyser.StatisticCategory.BOWLING))
            return new BowlerAdapter();
        else
            throw new CricketLeagueException("Unknown Category",CricketLeagueException.ExceptionType.NO_DATA);
    }

}