package com.bridgelabz.cricketleague;

import com.bridgelabz.csvbuilder.CSVBuilderException;
import com.bridgelabz.csvbuilder.CSVBuilderFactory;
import com.bridgelabz.csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CricketAnalyser {

    public int readData(String csvFilePath) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<Batsman> csvFileterator = csvBuilder.getCSVFileIterator(reader, Batsman.class);
            return this.getCount(csvFileterator);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getCount(Iterator iterator) {
        Iterable csvIterable = () -> iterator;
        int numOfEateries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
        return numOfEateries;
    }
}


