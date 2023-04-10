package com.mofidx.mysqlexternaldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseHelper extends SQLiteAssetHelper {

    public static final String DB_NAME= "nasheeds.db";
    public static final int DB_VERSION    = 1;

    public static final String NASH_TB_NAME= "nasheeds";
    public static final String NASH_CLMN_ID= "id";
    public static final String NASH_CLMN_IMG= "imge";
    public static final String NASH_CLMN_DESC= "desc";
    public static final String NASH_CLMN_LINK= "link";


    public DataBaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        //دالة يتم استدعاءها عند كل تحديث للداتابيس
//        //عند عمل تحديث وتغيير الجدول ورقم الاصدار يجب حذف الداتابيس القديم وانشاؤه من جديد هنا
//
//        db.execSQL("DROP TABLE IF EXISTS "+CAR_TB_NAME); //هذي لاتستعمل في حال كان البرنامج موجود على المتجر
//        //نستعمل الدالة اذا كان التطبيق على المتجر
////        db.execSQL("ALTER TABLE "+CAR_TB_NAME+" ADD manfuctureDate TEXT");
//        onCreate(db);
//    }




}
