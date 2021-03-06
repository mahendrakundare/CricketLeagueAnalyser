package com.bridgelabz.cricketleague;
import com.opencsv.bean.CsvBindByName;
public class Batsman {

    @CsvBindByName(column ="POS")
    public String position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    public String matches;

    @CsvBindByName(column = "Inns")
    public String innings;

    @CsvBindByName(column = "NO")
    public String notout;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "HS")
    public String highScore;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "BF")
    public int ballFaced;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "100" )
    public String century;

    @CsvBindByName(column = "50")
    public String halfcentury;

    @CsvBindByName(column = "4s")
    public int fours;

    @CsvBindByName(column = "6s")
    public int sixes;

    public Batsman() { }

    public Batsman(String player, double average, double strikeRate, int fours, int sixes, int ballFaced,int runs) {
        this.player=player;
        this.average=average;
        this.strikeRate=strikeRate;
        this.fours=fours;
        this.sixes=sixes;
        this.ballFaced=ballFaced;
        this.runs=runs;
    }
}