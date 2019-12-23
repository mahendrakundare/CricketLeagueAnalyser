package com.bridgelabz.cricketleague;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyser {
    private StatisticCategory category;
    public enum StatisticCategory {BATTING, BOWLING }
    Map<String, CricketLeagueDAO> batsmanMap=null;

    public CricketAnalyser() { }

    public CricketAnalyser(StatisticCategory category) {
        this.category= category;
    }

    public int readData(String csvFilePath) throws CricketLeagueException {
        CricketLeagueAdapter cricketLeagueAdapter = CricketLeagueFactory.getClassObject(category);
        batsmanMap = cricketLeagueAdapter.readData(csvFilePath);
        return batsmanMap.size();
    }

    public int getNumberOfRecord() {
        int count;
        return count = batsmanMap.size();
    }

    public String getSortedData(SortingFields.fields... sortField) {
        Comparator<CricketLeagueDAO>batsmanComparator=null;
        if (sortField.length==2)
            batsmanComparator = SortingFields.getParameter(sortField[0]).thenComparing(SortingFields.getParameter(sortField[1]));
        else {
            batsmanComparator=SortingFields.getParameter(sortField[0]);
        }
        ArrayList batsmanList=  batsmanMap.values().stream().
                sorted(batsmanComparator).
                map(batsmanDAO -> batsmanDAO.getBatsmanDTO()).
                collect(Collectors.toCollection(ArrayList::new));
        String sortedDataJson=new Gson().toJson(batsmanList);
        return sortedDataJson;
    }
}
