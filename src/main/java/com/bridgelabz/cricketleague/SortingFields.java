package com.bridgelabz.cricketleague;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingFields {

    public static Map<fields, Comparator> sortByFields = new HashMap<>();

    enum fields { AVERAGE,}

    public Comparator getParameter(SortingFields.fields parameter) {
        Comparator<Batsman> avgComparator = Comparator.comparing(batsmanRun -> batsmanRun.avg, Comparator.reverseOrder());
        sortByFields.put(fields.AVERAGE, avgComparator);
        Comparator<Batsman> comparator = sortByFields.get(parameter);
        return comparator;
    }
}
