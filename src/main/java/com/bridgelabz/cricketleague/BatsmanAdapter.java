package com.bridgelabz.cricketleague;
import com.bridgelabz.csvbuilder.CSVBuilderException;
import com.bridgelabz.csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

import static com.bridgelabz.csvbuilder.CSVBuilderFactory.createCSVBuilder;

public class BatsmanAdapter extends CricketLeagueAdapter {
    @Override
    public Map<String, CricketLeagueDAO> readData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueMap = super.readData(Batsman.class, csvFilePath[0]);
        if (csvFilePath.length>1)
            this.combineData(cricketLeagueMap,csvFilePath[1]);
        return cricketLeagueMap;
    }

    private int combineData(Map<String, CricketLeagueDAO> cricketLeagueMap, String csvFilePath) throws CricketLeagueException {
        Reader reader = null;
        try {
            reader= Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = createCSVBuilder();
            Iterator<Bowler> csvFileIterator = csvBuilder.getCSVFileIterator(reader, Bowler.class);
            Iterable<Bowler> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .filter(csvState -> cricketLeagueMap.get(csvState.player) != null)
                    .forEach(csvState -> {cricketLeagueMap.get(csvState.player).average = csvState.average;
                        cricketLeagueMap.get(csvState.player).wickets = csvState.wickets;
                    });
            return cricketLeagueMap.size();
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), e.type.name());
        }
    }
}
