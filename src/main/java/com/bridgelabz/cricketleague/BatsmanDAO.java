package com.bridgelabz.cricketleague;

public class BatsmanDAO {
    public String player;
    public String average;
    public String strikeRate;


    public BatsmanDAO(Batsman batsmanRuns) {
        this.player=batsmanRuns.player;
        this.average=batsmanRuns.average;
        this.strikeRate=batsmanRuns.strikeRate;
    }
}
