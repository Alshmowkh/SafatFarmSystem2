package com.alshmowkh.safatfarmsystem_2.fields;

public class Moalaga extends Field {

    private String apType;

    private int gaId;

    public Moalaga(int apId, String apType, String apName, int gaId) {
        super(apId, apName, null);

        this.apType = apType;

        this.gaId = gaId;
    }

}
