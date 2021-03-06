package com.bridgelabz.cricketleague;
import com.opencsv.bean.CsvBindByName;

public class Bowler {

    @CsvBindByName(column = "POS")
    public String pos;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    public int matches;

    @CsvBindByName(column = "Inns")
    public int innings;

    @CsvBindByName(column = "Ov")
    public double over;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "Wkts")
    public int wickets;

    @CsvBindByName(column = "BBI")
    public int bestBowlInning;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "Econ")
    public double economy;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "4w")
    public int fourWickets;

    @CsvBindByName(column = "5w")
    public int fiveWickets;

    public Bowler() { }

    public Bowler(String player, int wickets, double average, double economy, int fiveWickets, int fourWickets, double strikeRate) {
        this.player = player;
        this.wickets = wickets;
        this.average=average;
        this.economy=economy;
        this.fiveWickets=fiveWickets;
        this.fourWickets=fourWickets;
        this.strikeRate = strikeRate;
    }
}
