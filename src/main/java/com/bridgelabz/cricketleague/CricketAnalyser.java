package com.bridgelabz.cricketleague;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CricketAnalyser {

    public int readData(String csvFilePath) {
        int count=0;
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Batsman.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Batsman>batsmanIterator = csvToBean.iterator();
            while (batsmanIterator.hasNext()) {
                Batsman batsman = batsmanIterator.next();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
