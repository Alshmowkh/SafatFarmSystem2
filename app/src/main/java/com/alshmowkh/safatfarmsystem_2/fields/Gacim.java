package com.alshmowkh.safatfarmsystem_2.fields;

import java.util.List;

public class Gacim extends Field {

    int dhId;
    private List<Moalaga> moalagaList;
    public int sumAlmonds;
    private int sumGaats;
    private double sumAreaBeta;
    private double sumAreaDoc;
    private double sumAreaReal;

    public Gacim(int gaId, String gaName, byte[] gaImage, int dhId) {
        super(gaId, gaName, gaImage);

        this.dhId = dhId;
        this.sumAlmonds = -1;
    }


    public static Gacim bindNew(int gaId, String gaName, byte[] gaImage, int dhId) {
        return new Gacim(gaId, gaName, gaImage, dhId);
    }


    public List<Moalaga> getAppendixes() {
        return this.moalagaList;
    }


    public void bindAppendixes(List<Moalaga> moalagaList) {
        this.moalagaList = moalagaList;
    }

    public void sumGacimEnumerate() {
        if (sumAlmonds != -1) return;

        int sumAl = 0, sumGat = 0;
        double sumAreaB = 0.0, sumAreaD = 0.0, sumAreaR = 0.0;
        sumAl += getAlmonds();
        sumGat += getGaats();
        sumAreaB += getAreaBeta();
        sumAreaD += getAreaDoc();
        sumAreaR += getAreaReal();
        for (Moalaga moalaga : getAppendixes()) {
            sumAl += moalaga.getAlmonds();
            sumGat += moalaga.getGaats();
            sumAreaB += moalaga.getAreaBeta();
            sumAreaD += moalaga.getAreaDoc();
            sumAreaR += moalaga.getAreaReal();
        }
        this.sumAlmonds = sumAl;
        this.sumGaats = sumGat;
        this.sumAreaBeta = sumAreaB;
        this.sumAreaDoc = sumAreaD;
        this.sumAreaReal = sumAreaR;
//        System.out.println(almonds+"\n حبيبي");
    }

    public int getSumAlmonds() {
        if (sumAlmonds == -1) sumGacimEnumerate();
        return sumAlmonds;
    }

    public int getSumGaats() {
        if (sumAlmonds == -1) sumGacimEnumerate();
        return sumGaats;
    }

    public double getSumAreaBeta() {
        if (sumAlmonds == -1) sumGacimEnumerate();
        return sumAreaBeta;
    }
    public double getSumAreaDoc() {
        if (sumAlmonds == -1) sumGacimEnumerate();
        return sumAreaDoc;
    }
    public double getSumAreaReal() {
        if (sumAlmonds == -1) sumGacimEnumerate();
        return sumAreaReal;
    }
}
