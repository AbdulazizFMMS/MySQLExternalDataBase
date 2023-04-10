package com.mofidx.mysqlexternaldatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseAccess {
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    private static DataBaseAccess instance;

    private DataBaseAccess(Context context) {
        this.openHelper = new DataBaseHelper(context);
    }

    public static DataBaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DataBaseAccess(context);
        }

        return instance;
    }

    public void open(){
this.database = this.openHelper.getWritableDatabase();

    }
    public void close(){
    if (this.database!=null){
        this.database.close();
    }
    }





    //جالة الاضافة
    public boolean insertCar(nasheed nasheed){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.NASH_CLMN_IMG,nasheed.getImg());
        contentValues.put(DataBaseHelper.NASH_CLMN_DESC,nasheed.getDesc());
        contentValues.put(DataBaseHelper.NASH_CLMN_LINK,nasheed.getLink());


        long result =  database.insert(DataBaseHelper.NASH_TB_NAME,null,contentValues);

        return result != -1; //رجعها true اذا ماساوت 1- فإذا ماساوت 1- رجعها false

    }

    //دالة التعديل
    public boolean UpdateCar(nasheed nasheed){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.NASH_CLMN_IMG,nasheed.getImg());
        contentValues.put(DataBaseHelper.NASH_CLMN_DESC,nasheed.getDesc());
        contentValues.put(DataBaseHelper.NASH_CLMN_LINK,nasheed.getLink());


        String[] args = {String.valueOf(nasheed.getId())};

        //  دالة update ترجع لك عدد الصفوف اللتي تم التعديل عليها فإذا رجعت صفر يعني لم يتم التعديل على اي صف
        int result =  database.update(DataBaseHelper.NASH_TB_NAME, contentValues,"id=?",args);

        return result != 0; //رجعها true اذا ماساوت 0 فإذا ساوت 0 رجعها false

    }

    //دالة حساب عدد صفوف الجدول
    public long getDataBaseRowsNum(){

        return DatabaseUtils.queryNumEntries(database,DataBaseHelper.NASH_TB_NAME);
    }

    //دالة الحذف
    public boolean DeleteCar(nasheed nasheed){

        String[] args = {String.valueOf(nasheed.getId())};

        //  دالة delete ترجع لك عدد الصفوف اللتي تم الحذف منها فإذا رجعت صفر يعني لم يتم الحذف بنجاح
        int result =  database.delete(DataBaseHelper.NASH_TB_NAME,"id=?",args);

        return result != 0; //رجعها true اذا ماساوت 0 فإذا ساوت 0 رجعها false

    }

    //دالة الاسترجاع
    public ArrayList<nasheed> getAllNasheedfromDatbase(){
        ArrayList<nasheed> nasheedArrayList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+DataBaseHelper.NASH_TB_NAME,null);
        // كود التعامل مع الكيرسر وتحويله لمصفوفة من نوع نشيد
        // فحص هل الكيرسر يحتوي على بيانات في الصف التالي ام لا
        if (cursor!= null && cursor.moveToFirst()){
            do {
                // البحث عن العامود على حسب اسم العامود cursor.getColumnIndex()
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_ID));
                @SuppressLint("Range") String img = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_IMG));
                @SuppressLint("Range") String desc = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_DESC));
                @SuppressLint("Range") String link = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_LINK));

                nasheed nasheed = new nasheed(id,img,desc,link);

                nasheedArrayList.add(nasheed);

            }while (cursor.moveToNext());
            cursor.close();
        }

        return nasheedArrayList;
    }

    //دالة الاسترجاع معدلة بإستعمال البحث عن الموديل
    public ArrayList<nasheed> getCarmodel(String modelSearch){
        ArrayList<nasheed> nasheedArrayList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+ DataBaseHelper.NASH_TB_NAME +" WHERE "+DataBaseHelper.NASH_CLMN_DESC+" LIKE ?",new String[]{modelSearch+"%"});
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+CAR_TB_NAME+" WHERE "+CAR_CLMN_MODEL+"=?",new String[]{modelSearch});
        // كود التعامل مع الكيرسر وتحويله لمصفوفة من نوع كار
        // فحص هل الكيرسر يحتوي على بيانات في الصف التالي ام لا
        if (cursor!= null && cursor.moveToFirst()){
            do {
                // البحث عن العامود على حسب اسم العامود cursor.getColumnIndex()
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_ID));
                @SuppressLint("Range") String img = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_IMG));
                @SuppressLint("Range") String desc = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_DESC));
                @SuppressLint("Range") String link = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NASH_CLMN_LINK));

                nasheed nasheed = new nasheed(id,img,desc,link);

                nasheedArrayList.add(nasheed);

            }while (cursor.moveToNext());
            cursor.close();
        }

        return nasheedArrayList;
    }


}
