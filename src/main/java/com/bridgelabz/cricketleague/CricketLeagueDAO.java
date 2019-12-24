package com.bridgelabz.cricketleague;

public class CricketLeagueDAO {

    public String player;
    public double average;
    public double strikeRate;
    public int fours;
    public int sixes;
    public int ballFaced;
    public int runs;
    public int wickets;
    public double economy;
    public int fiveWickets;
    public int fourWickets;
    public double bowlingAverage;

    public CricketLeagueDAO(Batsman batsmanRuns) {
        this.player=batsmanRuns.player;
        this.average= batsmanRuns.average;
        this.strikeRate=batsmanRuns.strikeRate;
        this.sixes=batsmanRuns.sixes;
        this.fours=batsmanRuns.fours;
        this.ballFaced=batsmanRuns.ballFaced;
        this.runs=batsmanRuns.runs;
    }

    public CricketLeagueDAO(Bowler bowler) {
        this.player= bowler.player;
        this.wickets=bowler.wickets;
        this.bowlingAverage=bowler.average;
        this.economy = bowler.economy;
        this.fiveWickets = bowler.fiveWickets;
        this.fourWickets = bowler.fourWickets;
        this.strikeRate = bowler.strikeRate;
    }

    public CricketLeagueDAO() { }

    public CricketLeagueDAO(int position, String player, int mat, int innings, int no, int runs, double average, int ballFaced, double strikeRate, int century, int halfcentury, int fours, int sixes) {
        this.player = player;
        this.runs = runs;
        this.average = average;
        this.ballFaced = ballFaced;
        this.strikeRate =strikeRate;
        this.fours=fours;
        this.sixes=sixes;
    }

    public Object getBatsmanDTO(CricketAnalyser.StatisticCategory category) {
        if (category.equals(CricketAnalyser.StatisticCategory.BATTING))
            return new Batsman(player,average,strikeRate,sixes,fours,ballFaced,runs);
        return new Bowler(player,wickets,bowlingAverage,economy,fiveWickets,fourWickets,strikeRate);
    }
}
