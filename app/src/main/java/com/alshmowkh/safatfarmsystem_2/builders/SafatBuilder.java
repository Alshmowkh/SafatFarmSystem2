package com.alshmowkh.safatfarmsystem_2.builders;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.alshmowkh.safatfarmsystem_2.fields.Dhiah;
import com.alshmowkh.safatfarmsystem_2.fields.Gacim;
import com.alshmowkh.safatfarmsystem_2.fields.Moalaga;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SafatBuilder {

    private static SafatBuilder newInstance;
    private static List<Dhiah> dhiahs;
//    private static List<Gacim> dhiahs;


    public static SafatBuilder build() {
        newInstance = new SafatBuilder();
        String pathDb = Environment.getExternalStorageDirectory().getAbsolutePath() +
                File.separator + "Safat-androidProject/database/SafatDB-2.db";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathDb, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor curDhiah, curGacim, curAppendix, curEnum;
        if (db.isOpen()) {

            Dhiah dhiah;
            Gacim gacim;
            Moalaga moalaga;
            int dhId, gaId, apId, temp;
            String dhName, gaName, apType, apName, idGen, enType = null;
            byte[] dhImage, gaImage;
            List<Gacim> gacimList;
            List<Moalaga> moalagaList;
            dhiahs = new ArrayList<>();
            int almonds = -1, gaats = -1;
            double areaBeta = -0.0, areaDoc = -0.0, areaReal = -0.0;
            Object amount = null;

            curDhiah = db.rawQuery("select * from dhiah", null);
            while (curDhiah.moveToNext()) {
                dhId = curDhiah.getInt(0);
                dhName = curDhiah.getString(1);
                dhImage = curDhiah.getBlob(2);
                dhiah = new Dhiah(dhId, dhName, dhImage);
                curGacim = db.rawQuery("select * from Gacim where Dh_id=" + dhId + "", null);
                gacimList = new ArrayList<>();
                while (curGacim.moveToNext()) {
                    gaId = curGacim.getInt(0);
                    gaName = curGacim.getString(1);
                    gaImage = curGacim.getBlob(2);
                    gacim = Gacim.bindNew(gaId, gaName, gaImage, dhId);
                    gacimList.add(gacim);
                    moalagaList = new ArrayList<>();
                    idGen = gaId + "0";
                    curEnum = db.rawQuery("select * from Enumeration where Main_id='" + idGen + "'", null);
                    if (curEnum.moveToNext()) {
                        enType = curEnum.getString(1);
                        amount = curEnum.getDouble(2);
                        gacim.bindEnumerate(enType, amount);
                    }
                    curAppendix = db.rawQuery("select * from Appendix where Ga_id=" + gaId + "", null);
                    while (curAppendix.moveToNext()) {
                        apId = curAppendix.getInt(0);
                        apType = curAppendix.getString(1);
                        apName = curAppendix.getString(2);
                        moalaga = new Moalaga(apId, apType, apName, gaId);
                        curEnum = db.rawQuery("select * from Enumeration where Main_id='" + apId + "'", null);
                        while (curEnum.moveToNext()) {
                            enType = curEnum.getString(1);
                            amount = curEnum.getInt(2);
                            moalaga.bindEnumerate(enType, amount);
                        }
                        moalagaList.add(moalaga);
                    }
                    gacim.bindAppendixes(moalagaList);
                    gacim.sumGacimEnumerate();
                }
                dhiah.bindGacims(gacimList);
                dhiah.sumDhiahEnumerate();
                dhiahs.add(dhiah);
            }
            db.close();
        }

        return newInstance;
    }


    public Dhiah getDhiah(int dhId) {

        return dhiahs.get(dhId - 1);
    }

    public Dhiah getDhiah(String dhName) {
        for (Dhiah dhiah : dhiahs) {
            if (dhiah.getName().trim().equals(dhName)) {
                return dhiah;
            }
        }
        return null;
    }

    public List<Dhiah> getDhiahs() {
        return dhiahs;
    }


}
