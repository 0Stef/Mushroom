package cwb1.mushroom.com.mushroom;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainDBactivity extends AppCompatActivity {

    DataBaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dbactivity);

        System.out.println("    Start handler");

        handler = new DataBaseHandler(getApplicationContext());
        handler.onUpgrade(handler.getWritableDatabase(), 0, 0);

        System.out.println("    Start making points");

        AccelerometerPoint point0 = new AccelerometerPoint(14, 4, 7);
        AccelerometerPoint point1 = new AccelerometerPoint(10, 4, 9);
        AccelerometerPoint point2 = new AccelerometerPoint(7, 6, 7);

        GpsPoint point3 = new GpsPoint(2.0f, 200, 1500, 30.0f);
        GpsPoint point4 = new GpsPoint(3.0f, 900, 300, 56.0f);
        GpsPoint point5 = new GpsPoint(4.0f, 700, 150, 12.0f);

        System.out.println("    Start saving");

        handler.addAccelerometerPoint(point0);
        handler.addAccelerometerPoint(point1);
        handler.addAccelerometerPoint(point2);

        handler.addGpsPoint(point3);
        handler.addGpsPoint(point4);
        handler.addGpsPoint(point5);




        System.out.println("    Start reading");

        Cursor cursor = handler.getGreatestValue(handler.TABLE_ACCELEROMETER, handler.COLUMN_XVALUE);
        ArrayList<AccelerometerPoint> list0 = handler.getAccelerometerPoints(cursor);

        String searchQuery = "SELECT  * FROM " + handler.TABLE_GPS;
        ArrayList<GpsPoint> list1 = handler.getGpsPoints(handler.customSearch(searchQuery));

        System.out.println("getPoints: check");




        for (AccelerometerPoint point : list0) {
            System.out.println(point.getxValue());
        }

        System.out.println(list0.toString());
        handler.resetDataBase(handler.getWritableDatabase());

        System.out.println("    Program completed");
    }
}
