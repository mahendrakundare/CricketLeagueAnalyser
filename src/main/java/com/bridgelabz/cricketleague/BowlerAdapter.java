package com.bridgelabz.cricketleague;
import java.util.Map;

public class BowlerAdapter extends CricketLeagueAdapter {
    @Override
    public Map<String, CricketLeagueDAO> readData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueMap = super.readData(Bowler.class, csvFilePath[0]);
            return cricketLeagueMap;
    }
}