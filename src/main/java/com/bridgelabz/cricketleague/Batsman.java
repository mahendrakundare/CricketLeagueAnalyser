package com.bridgelabz.cricketleague;
import com.opencsv.bean.CsvBindByName;
public class Batsman {

    @CsvBindByName(column ="POS")
    public String pos;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public String mat;

    @CsvBindByName(column = "Inns")
    public String inns;

    @CsvBindByName(column = "NO", required = true)
    public String no;

    @CsvBindByName(column = "Runs",required = true)
    public String runs;

    @CsvBindByName(column = "HS", required = true)
    public String hs;

    @CsvBindByName(column = "Avg", required = true)
    public String avg;

    @CsvBindByName(column = "BF", required = true)
    public String bf;

    @CsvBindByName(column = "SR", required = true)
    public String sr;

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
        this.pos =batsman.pos;
        this.player =batsman.player;
        this.mat =batsman.mat;
        this.inns =batsman.inns;
        this.no =batsman.no;
        this.runs =batsman.runs;
        this.hs =batsman.hs;
        this.avg =batsman.avg;
        this.bf =batsman.bf;
        this.sr =batsman.sr;
        this.century=batsman.century;
        this.halfcentury =batsman.halfcentury;
        this.fours=batsman.fours;
        this.sixes=batsman.sixes;
    }
}
