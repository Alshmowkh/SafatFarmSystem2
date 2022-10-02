package com.alshmowkh.safatfarmsystem_2.fields;

import java.util.List;

public class Dhiah extends Field {


    private List<Gacim> gacimList;

    private int sumAlmonds;
    private int sumGaats;
    private double sumAreaBeta;
    private double sumAreaDoc;
    private double sumAreaReal;

    public Dhiah(int dhId, String dhName, byte[] dhImage) {
        super(dhId, dhName, dhImage);

        sumAlmonds = -1;
    }


    public Object getGacim(int gaId) {
        return null;
    }

    public void bindGacims(List<Gacim> gacimList) {
        this.gacimList = gacimList;
    }


    public List<Gacim> getGacims() {

        return this.gacimList;
    }

    public void sumDhiahEnumerate() {
        if (sumAlmonds != -1) return;

        int sumAl = 0, sumGat = 0;
        double sumAreaB = 0.0, sumAreaD = 0.0, sumAreaR = 0.0;
        for (Gacim gacim : this.gacimList) {
            sumAl += gacim.getSumAlmonds();
            sumGat += gacim.getSumGaats();
            sumAreaB += gacim.getSumAreaBeta();
            sumAreaD += gacim.getSumAreaDoc();
            sumAreaR += gacim.getSumAreaReal();
        }
        this.sumAlmonds = sumAl;
        this.sumGaats = sumGat;
        this.sumAreaBeta = sumAreaB;
        this.sumAreaDoc = sumAreaD;
        this.sumAreaReal = sumAreaR;
    }

    public int getSumAlmonds() {
        if (sumAlmonds == -1) sumDhiahEnumerate();
        return sumAlmonds;
    }

    public int getSumGaats() {
        if (sumAlmonds == -1) sumDhiahEnumerate();
        return sumGaats;
    }

    public double getSumAreaBeta() {
        if (sumAlmonds == -1) sumDhiahEnumerate();
        return sumAreaBeta;
    }
    public double getSumAreaDoc() {
        if (sumAlmonds == -1) sumDhiahEnumerate();
        return sumAreaDoc;
    }
    public double getSumAreaReal() {
        if (sumAlmonds == -1) sumDhiahEnumerate();
        return sumAreaReal;
    }
}
