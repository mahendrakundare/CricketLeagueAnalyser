package com.bridgelabz.cricketleague;
import com.bridgelabz.csvbuilder.CSVBuilderException;
import com.bridgelabz.csvbuilder.CSVBuilderFactory;
import com.bridgelabz.csvbuilder.ICSVBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketAnalyser {
    private StatisticCategory category;
    public enum StatisticCategory {BATTING, BOWLING }
    Map<String, BatsmanDAO> batsmanMap=null;

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
        Comparator<BatsmanDAO>batsmanComparator=null;
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
