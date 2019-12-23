package com.bridgelabz.cricketleague;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingFields {

    static Map<fields, Comparator> sortByFields = new HashMap<>();

    enum fields { AVERAGE,STRIKERATE,BOUNDARIES,RUNS, ECONOMY, FIVE_WICKETS, FOUR_WICKETS, STRIKE_WITH_BOUNDARY, AVERAGE_WITH_STRIKERATE, MAXIMUM_WICKET_WITH_AVERAGE, BATTING_AND_BOWLING_AVG, STRIKERATE_WITH_FIVE_AND_FOUR_WICKETS }

    public static Comparator getParameter(SortingFields.fields parameter) {
        Comparator<CricketLeagueDAO> avgComparator = Comparator.comparing(batsmanRun -> batsmanRun.average, Comparator.reverseOrder());
        Comparator<CricketLeagueDAO> strikeRateComparator = Comparator.comparing(batsman -> batsman.strikeRate,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO> boundariesComparator = Comparator.comparing(batsman -> batsman.fours*4+batsman.sixes*6,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>strikeRateWithBoundaryComparator=Comparator.comparing(batsman -> (batsman.fours*4+batsman.sixes*6/batsman.ballFaced),Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>runsCompartor=Comparator.comparing(batsman -> batsman.runs,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>bowlerStrikerateComparator= Comparator.comparing(bowler -> bowler.strikeRate);
        Comparator<CricketLeagueDAO>economyComparator= Comparator.comparing(bowler -> bowler.economy);
        Comparator<CricketLeagueDAO>fiveWickets4WicketsComparator = Comparator.comparing(bowler -> bowler.fiveWickets+bowler.fourWickets,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>wickets = Comparator.comparing(bowler -> bowler.wickets,Comparator.reverseOrder());
        Comparator<CricketLeagueDAO>bowlingAverage = Comparator.comparing(bowler -> bowler.average);
        sortByFields.put(fields.AVERAGE, avgComparator);
        sortByFields.put(fields.STRIKERATE,strikeRateComparator);
        sortByFields.put(fields.BOUNDARIES,boundariesComparator);
        sortByFields.put(fields.STRIKE_WITH_BOUNDARY,strikeRateWithBoundaryComparator);
        sortByFields.put(fields.RUNS,runsCompartor);
        sortByFields.put(fields.ECONOMY,economyComparator);
        sortByFields.put(fields.STRIKERATE_WITH_FIVE_AND_FOUR_WICKETS,fiveWickets4WicketsComparator.thenComparing(bowlerStrikerateComparator));
        sortByFields.put(fields.AVERAGE_WITH_STRIKERATE,avgComparator.thenComparing(bowlerStrikerateComparator));
        sortByFields.put(fields.MAXIMUM_WICKET_WITH_AVERAGE,wickets.thenComparing(bowlingAverage));
        sortByFields.put(fields.BATTING_AND_BOWLING_AVG,avgComparator.thenComparing(bowlingAverage));
        Comparator<CricketLeagueDAO> comparator = sortByFields.get(parameter);
        return comparator;
    }
}
