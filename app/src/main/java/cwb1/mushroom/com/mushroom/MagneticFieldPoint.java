package cwb1.mushroom.com.mushroom;

public class MagneticFieldPoint extends SensorPoint {

    private float magneticValue;

    public MagneticFieldPoint() {
        //Lege constructor
    }

    public MagneticFieldPoint(float magneticValue) {
        super();

        this.magneticValue = magneticValue;
    }

    public MagneticFieldPoint(float magneticValue, long millisec) {
        super(millisec);

        this.magneticValue = magneticValue;
    }

    public void setMagneticValue(float magneticValue) {
        this.magneticValue = magneticValue;
    }

    public float getMagneticValue() {
        return magneticValue;
    }
}
