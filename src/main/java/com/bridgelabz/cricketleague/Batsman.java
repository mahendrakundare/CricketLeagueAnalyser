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

    @CsvBindByName(column = "4s")
    public int fours;

    @CsvBindByName(column = "6s")
    public int sixes;

    public Batsman() { }

    public Batsman(Batsman batsman) {
        this.player=batsman.player;
        this.average=batsman.average;
        this.strikeRate=batsman.strikeRate;
        this.fours=batsman.fours;
        this.sixes=batsman.sixes;
    }

    public Batsman(String player, String average, String strikeRate, int fours, int sixes) {
        this.player=player;
        this.average=average;
        this.strikeRate=strikeRate;
        this.fours=fours;
        this.sixes=sixes;
    }
}
