package cwb1.mushroom.com.mushroom;

public class BarometerPoint extends SensorPoint{

    private float pressure;

    public BarometerPoint() {
        //Lege constructor
    }

    public BarometerPoint(float pressure) {
        super();

        this.pressure = pressure;
    }

    public BarometerPoint(float pressure, long millisec) {
        super(millisec);

        this.pressure = pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getPressure() {
        return pressure;
    }
}

