package com.bridgelabz.cricketleague;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingFields {

    static Map<fields, Comparator> sortByFields = new HashMap<>();

    enum fields { AVERAGE,STRIKERATE,BOUNDARIES, AVERAGE_WITH_STRIKE, STRIKE_WITH_BOUNDARY}

    public static Comparator getParameter(SortingFields.fields parameter) {
        Comparator<BatsmanDAO> avgComparator = Comparator.comparing(batsmanRun -> batsmanRun.average, Comparator.reverseOrder());
        Comparator<BatsmanDAO> strikeRateComparator = Comparator.comparing(batsman -> batsman.strikeRate,Comparator.reverseOrder());
        Comparator<BatsmanDAO> boundariesComparator = Comparator.comparing(batsman -> batsman.fours*4+batsman.sixes*6,Comparator.reverseOrder());
        Comparator<BatsmanDAO>strikeRateWithBoundaryComparator= Comparator.comparing(batsman -> (batsman.fours*4+batsman.sixes*6/batsman.ballFaced),Comparator.reverseOrder());
        sortByFields.put(fields.AVERAGE, avgComparator);
        sortByFields.put(fields.STRIKERATE,strikeRateComparator);
        sortByFields.put(fields.BOUNDARIES,boundariesComparator);
        sortByFields.put(fields.STRIKE_WITH_BOUNDARY,strikeRateWithBoundaryComparator);
        Comparator<BatsmanDAO> comparator = sortByFields.get(parameter);
        return comparator;
    }
}
