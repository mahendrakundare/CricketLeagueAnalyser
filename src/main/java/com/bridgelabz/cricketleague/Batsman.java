package com.bridgelabz.cricketleague;

import com.opencsv.bean.CsvBindByName;
//POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
//POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
public class Batsman {

    @CsvBindByName(column ="POS")
    public String POS;

    @CsvBindByName(column = "PLAYER")
    public String PLAYER;

    @CsvBindByName(column = "Mat", required = true)
    public String Mat;

    @CsvBindByName(column = "Inns")
    public String Inns;

    @CsvBindByName(column = "NO", required = true)
    public String NO;

    @CsvBindByName(column = "Runs",required = true)
    public String Runs;

    @CsvBindByName(column = "HS", required = true)
    public String HS;

    @CsvBindByName(column = "Avg", required = true)
    public String Avg;

    @CsvBindByName(column = "BF", required = true)
    public String BF;

    @CsvBindByName(column = "SR", required = true)
    public String SR;

    @CsvBindByName(column = "100" ,required = true)
    public String century;

    @CsvBindByName(column = "50",required = true)
    public String halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public String fours;

    @CsvBindByName(column = "6s",required = true)
    public String sixes;

    public Batsman(Batsman batsman) {
        this.POS=batsman.POS;
        this.PLAYER=batsman.PLAYER;
        this.Mat=batsman.Mat;
        this.Inns=batsman.Inns;
        this.NO=batsman.NO;
        this.Runs=batsman.Runs;
        this.HS=batsman.HS;
        this.Avg=batsman.Avg;
        this.BF=batsman.BF;
        this.SR=batsman.SR;
        this.century=batsman.century;
        this.halfCentury=batsman.halfCentury;
        this.fours=batsman.fours;
        this.sixes=batsman.sixes;
    }
}
