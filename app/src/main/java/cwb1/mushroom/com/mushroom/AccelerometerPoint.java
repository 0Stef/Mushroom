package cwb1.mushroom.com.mushroom;

public class AccelerometerPoint extends VectorSensorPoint {

    public AccelerometerPoint() {
        //Lege constructor
    }

    public AccelerometerPoint(float xValue, float yValue, float zValue) {
        super(xValue, yValue, zValue);
    }

    public AccelerometerPoint(float xValue, float yValue, float zValue, long millisec) {
        super(xValue, yValue, zValue, millisec);
    }
}