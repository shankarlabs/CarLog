package com.shankarlabs.carlog.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MaintenanceDBHelper extends SQLiteOpenHelper {

    private Context mContext;
    private static final String DATABASE_NAME = "Maintenance";
    private static int DATABASE_VERSION = 1;
    private SQLiteDatabase database = null;

    private static final String LOGTAG = "CarLog";
    private final String TABLE_CREATE = "CREATE TABLE " + DATABASE_NAME +
            " (_id INTEGER primary key autoincrement," +
            " TYPE TEXT," +
            " VEHICLE INTEGER, " +
            " ODOMETER INTEGER, " +
            " DATE TEXT, " +
            " COST REAL, " +
            " PERFORMEDAT TEXT, " +
            " COMMENTS TEXT);";

    public MaintenanceDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Add stuff to do when creating the DB. Called when the DB is created for the first time
        db.execSQL(TABLE_CREATE);
        Log.d(LOGTAG, "MaintenanceDBHelper : onCreate : Created Database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Update this method when updating the DB
    }
}
