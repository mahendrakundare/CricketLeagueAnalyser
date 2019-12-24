package com.bridgelabz.cricketleague;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class CricketAnalyserMokitoTest {
    private static final String SAMPLE_BATSMAN_FILE ="/home/admin1/IdeaProjects/CricketLeagueAnalyser/src/test/resources/SampleIPLData.csv";

    @Mock
    CricketLeagueAdapter cricketLeagueAdapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void givenSampleData_ShouldReturnExactCount() {
        try {
            Map<String , CricketLeagueDAO> cricketLeagueDAOMap = new HashMap<>();
            CricketLeagueDAO cricketLeagueDAO = new CricketLeagueDAO();
            cricketLeagueDAOMap.put("virat Kohli",cricketLeagueDAO);
            cricketLeagueDAOMap.put("hardik pandya",cricketLeagueDAO);
            CricketAnalyser cricketAnalyser = new CricketAnalyser();
            cricketAnalyser.setCricketLeagueAdapter(cricketLeagueAdapter);
            when(cricketLeagueAdapter.readData(SAMPLE_BATSMAN_FILE)).thenReturn(cricketLeagueDAOMap);
            Assert.assertEquals(2,cricketLeagueDAOMap.size());
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
