package com.bridgelabz.cricketleague;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class BatsmanAdapterTest {
    private static final String IPL2019_RUNS_CSV_FILE_PATH = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL2019_WICKETES_CSV_FILE_PATH = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_FILE = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostWktsy.csv";
    private static final String EMPTY_FILE = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/wrongfile.csv";
    private static final String FILE_WITH_DELIMETER_PROBLEM="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/Filewithdelimeter.csv";
    private static final String INVALID_HEADER_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/InvalidHeader.csv";
    private static final String SAMPLE_BATSMAN_FILE ="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/SampleIPLData.csv";
    private static final String SAMPLE_BOWLER_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/sampleBowlerFile.csv";


    @Test
    public void givenBatsmanData_ReturnExactPlayerCount() {
        try {
            BowlerAdapter batsmanAdapter = new BowlerAdapter();
            Map<String, CricketLeagueDAO> batsmanMap = batsmanAdapter.readData(SAMPLE_BATSMAN_FILE,SAMPLE_BOWLER_FILE);
            Assert.assertEquals(11,batsmanMap.size());
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_IFIncorrect_ShouldThrowException() {
        try {
            BowlerAdapter bowlerAdapter = new BowlerAdapter();
            Map<String, CricketLeagueDAO> batsmanMap = bowlerAdapter.readData(WRONG_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.FILE_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileISEmpty_ShouldThrowException() {
        try {
            BowlerAdapter bowlerAdapter = new BowlerAdapter();
            bowlerAdapter.readData(EMPTY_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.FILE_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidDelimeter_ShouldThrowError() {
        try {
            BowlerAdapter bowlerAdapter = new BowlerAdapter();
            bowlerAdapter.readData(FILE_WITH_DELIMETER_PROBLEM);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidHeader_ShouldThrowError() {
        try {
            BowlerAdapter bowlerAdapter = new BowlerAdapter();
            bowlerAdapter.readData(INVALID_HEADER_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }
}
