package com.bridgelabz.cricketleague;

import com.bridgelabz.csvbuilder.CSVBuilderException;
import com.bridgelabz.csvbuilder.CSVBuilderFactory;
import com.bridgelabz.csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class CricketLeagueAdapter {
    Map<String, CricketLeagueDAO> statisticsMap = new HashMap();
    public abstract Map<String, CricketLeagueDAO> readData(String... csvFilePath) throws CricketLeagueException;

    public <E> Map readData(Class<E> censusCSVClass, String... csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, censusCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (censusCSVClass.getName().equals("com.bridgelabz.cricketleague.Batsman")) {
                StreamSupport.stream(csvIterable.spliterator(), false).
                        map(Batsman.class::cast).
                        forEach(batsman -> statisticsMap.put(batsman.player, new CricketLeagueDAO(batsman)));
            } else if (censusCSVClass.getName().equals("com.bridgelabz.cricketleague.Bowler")) {
                StreamSupport.stream(csvIterable.spliterator(), false).
                        map(Bowler.class::cast).
                        forEach(bowler -> statisticsMap.put(bowler.player, new CricketLeagueDAO(bowler)));
            }
            return statisticsMap;
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.UNABLE_TO_PARSE);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }
}
