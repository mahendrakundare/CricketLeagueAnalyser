package com.bridgelabz.cricketleague;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CricketAnalyserMokitoTest {
    private static final String SAMPLE_BATSMAN_FILE ="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/SampleIPLData.csv";
    private static final String SAMPLE_BOWLER_FILE="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/sampleBowlerFile.csv";
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private HashMap<String, CricketLeagueDAO> batsmanMap;

    public void create() {
        this.batsmanMap = new HashMap<>();
        this.batsmanMap.put("perosn1", new CricketLeagueDAO( 6,"Chris Gayle",13,13,1,490,40.83,319,153.6,0,4,45,34));
        this.batsmanMap.put("person2", new CricketLeagueDAO(19,"Ajinkya Rahane",14,13,1,393,32.75,285,137.89,1,1,45,9));
        this.batsmanMap.put("person3", new CricketLeagueDAO(1,"David Warner",12,12,2,692,69.2,481,143.86,1,8,57,21));
        this.batsmanMap.put("person4", new CricketLeagueDAO(17,"Shane Watson",17,17,0,398,23.41,312,127.56,0,3,42,20));
        this.batsmanMap.put("person5", new CricketLeagueDAO(42,"Mandeep Singh",13,12,8,165,41.25,120,137.5,0,0,10,4));
        this.batsmanMap.put("person6", new CricketLeagueDAO(42,"Mandeep Singh",13,12,8,165,41.25,120,137.5,0,0,10,4));
    }
    @Test
    public void givenSampleData_ShouldReturnExactCount() {
        CricketLeagueAdapter cricketLeagueAdapter = mock(CricketLeagueAdapter.class);
        try {
            create();
            when(cricketLeagueAdapter.readData(SAMPLE_BATSMAN_FILE)).thenReturn(this.batsmanMap);
            CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
            cricketAnalyser.setCricketLeagueAdapter(cricketLeagueAdapter);
            int size = cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            Assert.assertEquals(6,size);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSampleBowlingData_ShouldReturnExactCount() {
        CricketLeagueAdapter cricketLeagueAdapter = mock(CricketLeagueAdapter.class);
        try {
            create();
            when(cricketLeagueAdapter.readData(SAMPLE_BOWLER_FILE)).thenReturn(this.batsmanMap);
            CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BOWLING);
            cricketAnalyser.setCricketLeagueAdapter(cricketLeagueAdapter);
            int size = cricketAnalyser.readData(SAMPLE_BOWLER_FILE);
            Assert.assertEquals(6,size);
        } catch (CricketLeagueException e) { }
    }

    @Test
    public void givenSampleBattingData_ShouldReturnSortedData() {
        CricketLeagueAdapter cricketLeagueAdapter = mock(CricketLeagueAdapter.class);
        try {
            create();
            when(cricketLeagueAdapter.readData(SAMPLE_BATSMAN_FILE)).thenReturn(this.batsmanMap);
            CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.StatisticCategory.BATTING);
            cricketAnalyser.setCricketLeagueAdapter(cricketLeagueAdapter);
            cricketAnalyser.readData(SAMPLE_BATSMAN_FILE);
            String sortedData = cricketAnalyser.getSortedData(SortingFields.fields.AVERAGE);
            Batsman[] batsmen = new Gson().fromJson(sortedData,Batsman[].class);
            Assert.assertEquals("David Warner",batsmen[0].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
