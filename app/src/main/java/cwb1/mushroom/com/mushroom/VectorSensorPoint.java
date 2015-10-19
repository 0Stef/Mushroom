package cwb1.mushroom.com.mushroom;

public abstract class VectorSensorPoint extends SensorPoint {

    private float xValue;
    private float yValue;
    private float zValue;

    public VectorSensorPoint() {
        //Nothing here.
    }

    public VectorSensorPoint(float xValue, float yValue, float zValue) {
        super();

        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
    }

    public VectorSensorPoint(float xValue, float yValue, float zValue, long millisec) {
        super(millisec);

        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
    }

    public void setxValue(float xValue) {
        this.xValue = xValue;
    }

    public float getxValue() {
        return xValue;
    }

    public void setyValue(float yValue) {
        this.yValue = yValue;
    }

    public float getyValue() {
        return yValue;
    }

    public void setzValue(float zValue) {
        this.zValue = zValue;
    }

    public float getzValue() {
        return zValue;
    }
}

