package com.bridgelabz.cricketleague;
import java.util.Map;

public class BatsmanAdapter extends CricketLeagueAdapter {
    @Override
    public Map<String, CricketLeagueDAO> readData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueMap = super.readData(Batsman.class, csvFilePath[0]);
        return cricketLeagueMap;
    }
}
