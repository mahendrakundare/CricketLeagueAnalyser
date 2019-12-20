package com.bridgelabz.cricketleague;

public class BatsmanDAO {
    public String player;
    public double average;
    public double strikeRate;
    public int fours;
    public int sixes;
    public int ballFaced;

    public BatsmanDAO(Batsman batsmanRuns) {
        this.player=batsmanRuns.player;
        this.average= batsmanRuns.average;
        this.strikeRate=batsmanRuns.strikeRate;
        this.sixes=batsmanRuns.sixes;
        this.fours=batsmanRuns.fours;
        this.ballFaced=batsmanRuns.ballFaced;
    }

    public Object getBatsmanDTO() {
        return new Batsman(player,average,strikeRate,sixes,fours,ballFaced);
    }
}