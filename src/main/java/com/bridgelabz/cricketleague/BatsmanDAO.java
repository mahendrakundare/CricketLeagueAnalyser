package com.bridgelabz.cricketleague;

public class BatsmanDAO {
    public String player;
    public String average;
    public String strikeRate;
    public int fours;
    public int sixes;

    public BatsmanDAO(Batsman batsmanRuns) {
        this.player=batsmanRuns.player;
        this.average=batsmanRuns.average;
        this.strikeRate=batsmanRuns.strikeRate;
        this.sixes=batsmanRuns.sixes;
        this.fours=batsmanRuns.fours;
    }

    public Object getBatsmanDTO() {
        return new Batsman(player,average,strikeRate,fours,sixes);
    }
}
