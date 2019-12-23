package com.bridgelabz.cricketleague;

public class BatsmanDAO {
    public String player;
    public double average;
    public double strikeRate;
    public int fours;
    public int sixes;
    public int ballFaced;
    public int runs;
    public int wickets;
    public double economy;

    public BatsmanDAO(Batsman batsmanRuns) {
        this.player=batsmanRuns.player;
        this.average= batsmanRuns.average;
        this.strikeRate=batsmanRuns.strikeRate;
        this.sixes=batsmanRuns.sixes;
        this.fours=batsmanRuns.fours;
        this.ballFaced=batsmanRuns.ballFaced;
        this.runs=batsmanRuns.runs;
    }

    public BatsmanDAO(Bowler bowler) {
        this.player= bowler.player;
        this.wickets=bowler.wickets;
        this.average=bowler.average;
        this.economy = bowler.economy;
    }

    public Object getBatsmanDTO() {
        return new Batsman(player,average,strikeRate,sixes,fours,ballFaced,runs);
    }
}


//this.bowlingAverage =iplmap.average.contains("-")?0:Double.parseDouble(iplmap.average);