package com.bridgelabz.cricketleague;
import com.opencsv.bean.CsvBindByName;
public class Batsman {

    @CsvBindByName(column ="POS")
    public String position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public String matches;

    @CsvBindByName(column = "Inns")
    public String innings;

    @CsvBindByName(column = "NO", required = true)
    public String notout;

    @CsvBindByName(column = "Runs",required = true)
    public String runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public String average;

    @CsvBindByName(column = "BF", required = true)
    public String ballFaced;

    @CsvBindByName(column = "SR", required = true)
    public String strikeRate;

    @CsvBindByName(column = "100" ,required = true)
    public String century;

    @CsvBindByName(column = "50",required = true)
    public String halfcentury;

    @CsvBindByName(column = "4s", required = true)
    public String fours;

    @CsvBindByName(column = "6s",required = true)
    public String sixes;

    public Batsman() {
    }

    public Batsman(Batsman batsman) {
//        this.position =batsman.position;
        this.player =batsman.player;
//        this.matches =batsman.matches;
//        this.innings =batsman.innings;
//        this.notout =batsman.notout;
//        this.runs =batsman.runs;
//        this.highScore =batsman.highScore;
        this.average =batsman.average;
//        this.ballFaced =batsman.ballFaced;
        this.strikeRate =batsman.strikeRate;
//        this.century=batsman.century;
//        this.halfcentury =batsman.halfcentury;
//        this.fours=batsman.fours;
//        this.sixes=batsman.sixes;
    }
}
