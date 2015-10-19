package cwb1.mushroom.com.mushroom;

public class GyroscopePoint extends VectorSensorPoint{

    public GyroscopePoint() {
        //Lege constructor
    }

    public GyroscopePoint(float xValue, float yValue, float zValue) {
        super(xValue, yValue, zValue);
    }

    public GyroscopePoint(float xValue, float yValue, float zValue, long millisec) {
        super(xValue, yValue, zValue, millisec);
    }
}
