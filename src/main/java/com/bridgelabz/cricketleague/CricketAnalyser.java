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
    Map<String, BatsmanDAO> batsmanMap;

    public CricketAnalyser() {
        this.batsmanMap = new HashMap<>();
    }

    public Map readData(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<Batsman> csvFileterator = csvBuilder.getCSVFileIterator(reader, Batsman.class);
            Iterable<Batsman> csvIterable = () -> csvFileterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(Batsman.class::cast)
                    .forEach(batsmanRuns -> batsmanMap.put(batsmanRuns.player, new BatsmanDAO(batsmanRuns)));
            return batsmanMap;
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.UNABLE_TO_PARSE);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.DELIMITER_OR_HEADER_PROBLEM);
        }
    }

    public int getNumberOfRecord( String csvFilePath) {
        int count=0;
        try {
            Map<String, BatsmanDAO> batsmanMap1 = readData(csvFilePath);
           return count=batsmanMap1.size();
        } catch (CricketLeagueException e) { }
        return count;
    }

    public String getSortedData(SortingFields.fields sortFields) {
        Comparator<BatsmanDAO>batsmanComparator=new SortingFields().getParameter(sortFields);
        ArrayList batsmanList=  batsmanMap.values().stream().
                                    sorted(batsmanComparator).
                                    collect(Collectors.toCollection(ArrayList::new));
            String sortedDataJson=new Gson().toJson(batsmanList);
            return sortedDataJson;
    }
}
