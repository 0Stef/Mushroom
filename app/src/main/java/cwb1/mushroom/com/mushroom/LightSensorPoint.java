package cwb1.mushroom.com.mushroom;

public class LightSensorPoint extends SensorPoint {

    private float lightValue;

    public LightSensorPoint() {
        //Lege constructor
    }

    public LightSensorPoint(float lightValue) {
        super();

        this.lightValue = lightValue;
    }

    public LightSensorPoint(float lightValue, long millisec) {
        super(millisec);

        this.lightValue = lightValue;
    }

    public void setLightValue(float lightValue) {
        this.lightValue = lightValue;
    }

    public float getLightValue() {
        return lightValue;
    }
}
