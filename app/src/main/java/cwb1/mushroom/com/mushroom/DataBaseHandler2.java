package cwb1.mushroom.com.mushroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;

import java.util.ArrayList;

public class DataBaseHandler2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GeneralDatabase2.db";

    private static final String CREATE = "CREATE TABLE ";
    private static final String START_COLUMNS = " (";
    private static final String STOP_COLUMNS = ");";
    private static final String FLOAT = " REAL ";
    private static final String LONG = " INTEGER ";
    private static final String DOUBLE = " REAL ";
    private static final String COMMA = ", ";


    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TIME = "TIME";

    // Accelerometer data

    public static final String COLUMN_ACC_X = "Accelerometer_xValue";
    public static final String COLUMN_ACC_Y = "Accelerometer_yValue";
    public static final String COLUMN_ACC_Z = "Accelerometer_zValue";


    // Gps data
    public static final String COLUMN_GPS_VEL  = "velocity";
    public static final String COLUMN_GPS_LONG = "longitude";
    public static final String COLUMN_GPS_LAT = "latitude";
    public static final String COLUMN_GPS_ALT= "altitude";


    // Magneticfield data
    public static final String COLUMN_MAGN_X = "Magnetic_xValue";
    public static final String COLUMN_MAGN_Y = "Magnetic_yValue";
    public static final String COLUMN_MAGN_Z = "Magnetic_zValue";

    public DataBaseHandler2(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db2){
        String db2querry = "CREATE TABLE" + "TABLE" + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY" + "," +
                COLUMN_TIME + " TIMESTAMP " + "," +
                COLUMN_ACC_X + FLOAT + "," +
                COLUMN_ACC_Y + FLOAT + "," +
                COLUMN_ACC_Z + FLOAT + ","+
                COLUMN_MAGN_X + FLOAT + ","+
                COLUMN_MAGN_Y + FLOAT + "," +
                COLUMN_MAGN_Z + FLOAT + "," +
                COLUMN_GPS_VEL + FLOAT + "," +
                COLUMN_GPS_LONG +  DOUBLE  +
                COLUMN_GPS_LAT + DOUBLE +
                COLUMN_GPS_ALT + FLOAT  + ");" ;
        db2.execSQL(db2querry);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        deleteDataBase(db2);

        // create new tables
        onCreate(db2);
    }

    public void closeDataBase() {
        SQLiteDatabase db2 = this.getReadableDatabase();
        if (db2 != null && db2.isOpen())
            db2.close();
    }

    public void resetDataBase(SQLiteDatabase db2) {
        db2.delete("TABLE", null, null);
    }

    public void deleteDataBase(SQLiteDatabase db2) {
        db2.execSQL("DROP TABLE IF EXISTS " + "TABLE");
    }

    public void addPoint(dbclass.dbabstract  point) {
        SQLiteDatabase db2 = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TIME, point.getMillisec());
        values.put(COLUMN_ACC_X, point.getMagnetic_xValue());
        values.put(COLUMN_ACC_Y, point.getMagnetic_yValue());
        values.put(COLUMN_ACC_Z, point.getMagnetic_zValue());

        db2.insert("TABLE", null, values);
    }

    public ArrayList<AccelerometerPoint> getPoint(Cursor cursor) {
        ArrayList<AccelerometerPoint> list = new ArrayList<AccelerometerPoint>();

        if (cursor.moveToFirst()) {
            do {
                Point point = new Point();

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

}

