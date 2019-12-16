package com.bridgelabz.cricketleague;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketAnalyserTest {
    private static final String IPL2019_RUNS_CSV_FILE_PATH = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL2019_WICKETES_CSV_FILE_PATH = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String WRONG_FILE = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostWktsy.csv";
    private static final String EMPTY_FILE = "/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/wrongfile.csv";
    private static final String FILE_WITH_DELIMETER_PROBLEM="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/Filewithdelimeter.csv";
    private static final String INVALID_HEADER_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/InvalidHeader.csv";
    private static final String SAMPLE_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/SampleIPLData.csv";

    @Test
    public void givenLeagueDataCSVFile_ShouldReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        int result=cricketAnalyser.getNumberOfRecord(IPL2019_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(100,result);
    }

    @Test
    public void givenLeagueCSVFile_IFIncorrect_ShouldThrowException() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(WRONG_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.FILE_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileISEmpty_ShouldThrowException() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(EMPTY_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidDelimeter_ShouldThrowError() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(FILE_WITH_DELIMETER_PROBLEM);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidHeader_ShouldThrowError() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(INVALID_HEADER_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnAverage_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(SAMPLE_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE);
            Batsman[] batsmen = new Gson().fromJson(sortedData, Batsman[].class);
            Assert.assertEquals("MS Dhoni",batsmen[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnStrikeRate_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(SAMPLE_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.STRIKERATE);
            BatsmanDAO[] batsmen = new Gson().fromJson(sortedData, BatsmanDAO[].class);
            Assert.assertEquals("Ishant Sharma",batsmen[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedonFoursAndSixesShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser();
        try {
            cricketAnalyser.readData(SAMPLE_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.BOUNDARIES);
            BatsmanDAO[] batsman = new Gson().fromJson(sortedData, BatsmanDAO[].class);
            Assert.assertEquals("Chris Gayle",batsman[0].player);
        } catch (CricketLeagueException e) { }
    }
}
