package com.bridgelabz.cricketleague;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingFields {

    static Map<fields, Comparator> sortByFields = new HashMap<>();

    enum fields { AVERAGE,STRIKERATE,BOUNDARIES,RUNS, ECONOMY, STRIKE_WITH_BOUNDARY}

    public static Comparator getParameter(SortingFields.fields parameter) {
        Comparator<CricketLeagueDAO> avgComparator = Comparator.comparing(batsmanRun -> batsmanRun.average, Comparator.reverseOrder());
        Comparator<CricketLeagueDAO> strikeRateComparator = Comparator.comparing(batsman -> batsman.strikeRate,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO> boundariesComparator = Comparator.comparing(batsman -> batsman.fours*4+batsman.sixes*6,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>strikeRateWithBoundaryComparator= Comparator.comparing(batsman -> (batsman.fours*4+batsman.sixes*6/batsman.ballFaced),Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>runsCompartor=Comparator.comparing(batsman -> batsman.runs,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>economyComparator= Comparator.comparing(bowler -> bowler.economy);
        sortByFields.put(fields.AVERAGE, avgComparator);
        sortByFields.put(fields.STRIKERATE,strikeRateComparator);
        sortByFields.put(fields.BOUNDARIES,boundariesComparator);
        sortByFields.put(fields.STRIKE_WITH_BOUNDARY,strikeRateWithBoundaryComparator);
        sortByFields.put(fields.RUNS,runsCompartor);
        sortByFields.put(fields.ECONOMY,economyComparator);
        Comparator<CricketLeagueDAO> comparator = sortByFields.get(parameter);
        return comparator;
    }
}
