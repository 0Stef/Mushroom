package cwb1.mushroom.com.mushroom;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * @author Pieter-Jan
 * @version 1.0
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    // Algemene gegevens
    private static final int DATABASE_VERSION = 1;
    private static final String DAtABASE_NAME = "GeneralDatabase.db";

    private static final String CREATE = "CREATE TABLE ";
    private static final String START_COLUMNS = " (";
    private static final String STOP_COLUMNS = ");";
    private static final String FLOAT = " REAL ";
    private static final String LONG = " INTEGER ";
    private static final String DOUBLE = " REAL ";
    private static final String COMMA = ", ";

    // Accelerometer data
    public static final String TABLE_ACCELEROMETER = "accelerometer";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MILLISEC = "millisec";
    public static final String COLUMN_XVALUE = "xValue";
    public static final String COLUMN_YVALUE = "yValue";
    public static final String COLUMN_ZVALUE = "zValue";

    // Barometer data
    private static final String TABLE_BAROMETER = "barometer";

    // Gps data
    public static final String TABLE_GPS = "gps";
    public static final String COLUMN_VELOCITY  = "velocity";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_ALTITUDE = "altitude";

    // Gyroscope data
    private static final String TABLE_GYROSCOPE = "gyroscope";

    // Lightsensor data
    public static final String TABLE_LIGHTSENSOR = "lightsensor";

    // Magneticfield data
    public static final String TABLE_MAGNETICFIELD = "magneticfield";

    public DataBaseHandler(Context context) {
        super(context, DAtABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE accelerometer (_id INTEGER PRIMARY KEY AUTOINCREMENT , millisec INTEGER , xValue REAL , yValue REAL , zValue REAL);
        String accQuery = CREATE + TABLE_ACCELEROMETER + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_XVALUE + FLOAT + COMMA +
                COLUMN_YVALUE + FLOAT + COMMA +
                COLUMN_ZVALUE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(accQuery);

        String barQuery = CREATE + TABLE_BAROMETER + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_XVALUE + FLOAT + COMMA +
                COLUMN_YVALUE + FLOAT + COMMA +
                COLUMN_ZVALUE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(barQuery);

        String gpsQuery = CREATE + TABLE_GPS + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_VELOCITY + FLOAT + COMMA +
                COLUMN_LONGITUDE + DOUBLE + COMMA +
                COLUMN_LATITUDE + DOUBLE + COMMA +
                COLUMN_ALTITUDE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(gpsQuery);

        String gyrQuery = CREATE + TABLE_GYROSCOPE + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_XVALUE + FLOAT + COMMA +
                COLUMN_YVALUE + FLOAT + COMMA +
                COLUMN_ZVALUE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(gyrQuery);

        String ligQuery = CREATE + TABLE_LIGHTSENSOR + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_XVALUE + FLOAT + COMMA +
                COLUMN_YVALUE + FLOAT + COMMA +
                COLUMN_ZVALUE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(ligQuery);

        String magQuery = CREATE + TABLE_MAGNETICFIELD + START_COLUMNS +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                COLUMN_MILLISEC + LONG + COMMA +
                COLUMN_XVALUE + FLOAT + COMMA +
                COLUMN_YVALUE + FLOAT + COMMA +
                COLUMN_ZVALUE + FLOAT +
                STOP_COLUMNS;
        db.execSQL(magQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        deleteDataBase(db);

        // create new tables
        onCreate(db);
    }

    public void closeDataBase() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public void resetDataBase(SQLiteDatabase db) {
        db.delete(TABLE_ACCELEROMETER, null, null);
    }

    public void deleteDataBase(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCELEROMETER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BAROMETER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GPS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GYROSCOPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIGHTSENSOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAGNETICFIELD);
    }

    public void addAccelerometerPoint(AccelerometerPoint point) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MILLISEC, point.getMillisec());
        values.put(COLUMN_XVALUE, point.getxValue());
        values.put(COLUMN_YVALUE, point.getyValue());
        values.put(COLUMN_ZVALUE, point.getzValue());

        db.insert(TABLE_ACCELEROMETER, null, values);
    }

    public void addBarometerPoint(BarometerPoint point) {
        //TODO addBarometerPoint
    }

    public void addGpsPoint(GpsPoint point) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MILLISEC, point.getMillisec());
        values.put(COLUMN_VELOCITY, point.getVelocity());
        values.put(COLUMN_LONGITUDE, point.getLongitude());
        values.put(COLUMN_LATITUDE, point.getLatitude());
        values.put(COLUMN_ALTITUDE, point.getAltitude());

        db.insert(TABLE_GPS, null, values);
    }

    public void addGyroscopePoint(GyroscopePoint point) {
        //TODO addGyroscopePoint
    }

    public void addLightSensorPoint(LightSensorPoint point) {
        //TODO addLightSensorPoint
    }

    public void addMagneticFieldPoint(MagneticFieldPoint point) {
        //TODO addMagneticFieldPoint
    }

    public ArrayList<AccelerometerPoint> getAccelerometerPoints(Cursor cursor) {
        ArrayList<AccelerometerPoint> list = new ArrayList<AccelerometerPoint>();

        if (cursor.moveToFirst()) {
            do {
                AccelerometerPoint point = new AccelerometerPoint();

                point.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                point.setMillis(cursor.getLong(cursor.getColumnIndex(COLUMN_MILLISEC)));

                point.setxValue(cursor.getFloat(cursor.getColumnIndex(COLUMN_XVALUE)));
                point.setyValue(cursor.getFloat(cursor.getColumnIndex(COLUMN_YVALUE)));
                point.setzValue(cursor.getFloat(cursor.getColumnIndex(COLUMN_ZVALUE)));

                list.add(point);
            } while (cursor.moveToNext());
        }

        return list;
    }

    public ArrayList<BarometerPoint> getBarometerpoints(Cursor cursor) {
        //TODO getBaromerPoints
        return null;
    }

    public ArrayList<GpsPoint> getGpsPoints(Cursor cursor) {
        ArrayList<GpsPoint> list = new ArrayList<GpsPoint>();

        if (cursor.moveToFirst()) {
            do {
                GpsPoint point = new GpsPoint();

                point.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                point.setMillis(cursor.getLong(cursor.getColumnIndex(COLUMN_MILLISEC)));

                point.setVelocity(cursor.getFloat(cursor.getColumnIndex(COLUMN_VELOCITY)));
                point.setLongitude(cursor.getLong(cursor.getColumnIndex(COLUMN_LONGITUDE)));
                point.setLatitude(cursor.getLong(cursor.getColumnIndex(COLUMN_LATITUDE)));
                point.setAltitude(cursor.getFloat(cursor.getColumnIndex(COLUMN_ALTITUDE)));

                list.add(point);
            } while (cursor.moveToNext());
        }

        return list;
    }

    public ArrayList<GyroscopePoint> getGyroscopePoints(Cursor cursor) {
        //TODO getGyroscopePoints
        return null;
    }

    public ArrayList<LightSensorPoint> getLightSensorPoints(Cursor cursor) {
        //TODO getLightSensorPoints
        return null;
    }

    public ArrayList<MagneticFieldPoint> getMagneticFieldPoints(Cursor cursor) {
        //TODO getMagneticFieldPoints
        return null;
    }

    public Cursor customSearch(String searchQuery) {

        /**
         *Voorbeelden:
         *String searchQuery = "SELECT * FROM " + TABLE_ACCELEROMETER;
         *String searchQuery = "SELECT * FROM " + TABLE_ACCELEROMETER + " WHERE " + COLUMN_XVALUE + " >= 10 AND " + COLUMN_ZVALUE + " < 8";
         */

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(searchQuery, null);

        return cursor;
    }

    public Cursor getGreatestValue(String table, String column) {
        //SELECT * FROM TABLE WHERE COLUMN = (SELECT MAX(COLUMN) FROM TABLE)
        String searchQuery = "SELECT * FROM " + table + " WHERE " + column + " = (SELECT MAX(" + column + ") FROM " + table + ")";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(searchQuery, null);

        return cursor;
    }

    public Cursor getAllMeasurements(String table) {
        String searchQuery = "SELECT * FROM " + table;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(searchQuery, null);

        return cursor;
    }

    public Cursor getAllAfter(String table, long millisec) {
        String searchQuery = "SELECT * FROM " + table + " WHERE " + COLUMN_MILLISEC + " > " + millisec;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(searchQuery, null);
        return null;
    }
}
