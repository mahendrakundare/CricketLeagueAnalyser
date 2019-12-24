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
    private static final String SAMPLE_BATSMAN_FILE ="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/SampleIPLData.csv";
    private static final String SAMPLE_BOWLER_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/sampleBowlerFile.csv";

    @Test
    public void givenLeagueDataCSVFile_ShouldReturnExactCount() throws CricketLeagueException {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            int result = cricketAnalyser.readData(IPL2019_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100,result);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_IFIncorrect_ShouldThrowException() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(WRONG_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.FILE_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileISEmpty_ShouldThrowException() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(EMPTY_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidDelimeter_ShouldThrowError() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(FILE_WITH_DELIMETER_PROBLEM);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_IfFileHasInvalidHeader_ShouldThrowError() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(INVALID_HEADER_FILE);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(e.type, CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnAverage_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE);
            Batsman[] batsmen = new Gson().fromJson(sortedData, Batsman[].class);
            Assert.assertEquals("MS Dhoni",batsmen[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnStrikeRate_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.STRIKERATE);
            CricketLeagueDAO[] batsmen = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Ishant Sharma",batsmen[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedonFoursAndSixesShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.BOUNDARIES);
            Batsman[] batsman = new Gson().fromJson(sortedData, Batsman[].class);
            Assert.assertEquals("Chris Gayle",batsman[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnFoursAndSixesBasedAlongWithStrike_ShouldRetrunSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.STRIKE_WITH_BOUNDARY);
            CricketLeagueDAO[] batsman = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("David Warner",batsman[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnAverageWithBestStrikingRate_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE, SortingFields.fields.STRIKERATE);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("MS Dhoni", cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_WhenSortedOnMaxRunWithBestAverage_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.RUNS, SortingFields.fields.AVERAGE);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("David Warner", cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVBowlingFile_ShouldReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            int result=cricketAnalyser.getNumberOfRecord();
            Assert.assertEquals(99,result);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVBowlerFile_WhenSortedOnAverage_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE);
            Bowler[] bowlers = new Gson().fromJson(sortedData, Bowler[].class);
            Assert.assertEquals("Umesh Yadav",bowlers[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueCSVFile_ReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            int result = cricketAnalyser.readData(IPL2019_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100,result);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_ReturnExactCount() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            int result = cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            Assert.assertEquals(99,result);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_WhenSortedOnStrikeRates_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(SAMPLE_BOWLER_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.STRIKERATE);
            Bowler[] bowlers = new Gson().fromJson(sortedData, Bowler[].class);
            Assert.assertEquals("Khaleel Ahmed",bowlers[9].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_WhenSortedOnEconomy_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(SAMPLE_BOWLER_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.ECONOMY);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Jasprit Bumrah", cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_WhenSortedOn5WicketsAnd4Wickets_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.STRIKERATE_WITH_FIVE_AND_FOUR_WICKETS);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Kagiso Rabada",cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_WhenSortedOnAverageWithStrikeRate_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE_WITH_STRIKERATE);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Krishnappa Gowtham",cricketLeagueDAOS[98].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerCSVFile_WhenSortedOnMaximumWicketsWithStrikerate_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.MAXIMUM_WICKET_WITH_AVERAGE);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Imran Tahir",cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerAndBatsmanCSVFile_WhenSortedOnAverage_ShouldReturnSortedResult() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BOWLING));
            cricketAnalyser.readData(IPL2019_WICKETES_CSV_FILE_PATH,IPL2019_RUNS_CSV_FILE_PATH );
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.BATTING_AND_BOWLING_AVG);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Umesh Yadav",cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenLeagueBowlerAndBatsmanCSVFile_WhenSortedonMostRunAndWickets() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
        try {
            cricketAnalyser.setCricketLeagueAdapter(CricketLeagueFactory.getClassObject(CricketAnalyser.StatisticCategory.BATTING));
            cricketAnalyser.readData(IPL2019_RUNS_CSV_FILE_PATH,IPL2019_WICKETES_CSV_FILE_PATH);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.RUNS_WICKETS);
            CricketLeagueDAO[] cricketLeagueDAOS = new Gson().fromJson(sortedData, CricketLeagueDAO[].class);
            Assert.assertEquals("Hardik Pandya",cricketLeagueDAOS[0].player);
        } catch (CricketLeagueException e) { }
    }
}



