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
import java.util.stream.StreamSupport;

public class CricketAnalyser {
    Map<String, Batsman> batsmanMap;

    public CricketAnalyser() {
        this.batsmanMap = new HashMap<>();
    }

    public int readData(String csvFilePath) throws CricketLeagueException {
        int count=0;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<Batsman> csvFileterator=csvBuilder.getCSVFileIterator(reader, Batsman.class);
            Iterable<Batsman> csvIterable = () -> csvFileterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .map(Batsman.class::cast)
                    .forEach(iplRuns -> this.batsmanMap.put(iplRuns.PLAYER, iplRuns));
            return batsmanMap.size();
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.UNABLE_TO_PARSE);
        }  catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }
}

