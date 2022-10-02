package com.alshmowkh.safatfarmsystem_2.fields;

public class Field {

    private int id;
    private String name;
    private byte[] image;

    private int almonds;
    private int gaats;
    private double areaBeta;
    private double areaDoc;
    private double areaReal;


    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public int getGaats() {
        return gaats;
    }

    public double getAreaBeta() {
        return areaBeta;
    }

    public double getAreaDoc() {
        return areaDoc;
    }

    public double getAreaReal() {
        return areaReal;
    }


    public Field(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public void bindAlmonds(int count) {
        this.almonds = count;
    }

    public void bindGaats(int count) {
        this.gaats = count;
    }

    public void bindAreaBeta(double area) {
        this.areaBeta = area;
    }

    public void bindAreaDoc(double area) {
        this.areaDoc = area;
    }

    public void bindAreaReal(double area) {
        this.areaReal = area;
    }

    public String getName() {
        return this.name;
    }



    public int getAlmonds() {
        return almonds;

    }

    public void bindEnumerate(String enType, Object amount) {


        switch (enType) {
            case "لوز":
                bindAlmonds(((Double)(Double.parseDouble(amount.toString()))).intValue());
                break;
            case "قات":
                bindGaats(((Double)(Double.parseDouble(amount.toString()))).intValue());
                break;
            case "مساحة-تقريبية":
                bindAreaBeta(Double.parseDouble(amount.toString()));
                break;
            case "مساحة-واقعية":

                bindAreaReal((double) amount);
                break;
            case "مساحة-مستند":
                bindAreaDoc((double) amount);
                break;
            default:

        }
    }

}
