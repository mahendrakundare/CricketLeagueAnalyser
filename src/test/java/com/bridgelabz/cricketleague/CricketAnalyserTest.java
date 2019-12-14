package com.bridgelabz.cricketleague;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CricketAnalyserTest {
    private static final String IPL2019_RUNS_CSV_FILE_PATH = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL2019_WICKETES_CSV_FILE_PATH="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenLeagueDataCSVFile_ShouldReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        int totalRecord = 0;
        try {
            totalRecord = cricketAnalyser.readData(IPL2019_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101,totalRecord);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
