package com.vedant.demoaccountmanager.orm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.vedant.demoaccountmanager.orm.models.ModelRegistry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vedant on 17-01-2017.
 */

public class OModel extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "demo";
    static final int DATABASE_VERSION = 1;
    public String mModelName;
    private Context mContext;

    OColumn _id = new OColumn("Local id", ColumnType.INTEGER).makePrimaryKey()
            .makeAutoIncrement().makeLocal();


    public OModel(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mModelName = name;
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        HashMap<String, OModel> map = new ModelRegistry().models(mContext);
        for (OModel model : map.values()) {
            QueryBuilder queryBuilder = new QueryBuilder(model);
            String sql = queryBuilder.createQuery();
            if (sql != null) {
                db.execSQL(sql);
            }
        }
        Log.e(">>>>>>>>>", "Models are registered");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String getTableName() {
        return mModelName.replace(".", "_");
    }

    public String getModelName() {
        return mModelName;
    }

    public List<OColumn> getAllColumns() {
        List<OColumn> columnList = new ArrayList<>();
        List<Field> fieldList = new ArrayList<>();

        fieldList.addAll(Arrays.asList(getClass().getSuperclass().getDeclaredFields()));
        fieldList.addAll(Arrays.asList(getClass().getDeclaredFields()));

        for (Field field : fieldList) {
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(OColumn.class)) {
                try {
                    OColumn column = (OColumn) field.get(this);
                    column.name = field.getName();
                    columnList.add(column);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return columnList;
    }

    public int create(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert(getTableName(), null, values);
        db.close();
        return (int) id;
    }

    public int update(ContentValues values, String where, String[] wherevalues) {
        SQLiteDatabase db = getWritableDatabase();
        long id = db.update(getTableName(), values, where, wherevalues);
        db.close();
        return (int) id;
    }

    public int delete(String where, String[] wherevalues) {
        SQLiteDatabase db = getWritableDatabase();
        long id = db.delete(getTableName(),where,wherevalues);
        db.close();
        return (int) id;
    }

    public int count() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(*) AS TOTAL FROM " + getTableName(), null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return count;
    }
}
