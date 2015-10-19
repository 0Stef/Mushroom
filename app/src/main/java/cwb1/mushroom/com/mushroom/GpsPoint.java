package cwb1.mushroom.com.mushroom;


public class GpsPoint extends SensorPoint{

    private float velocity;
    private double longitude;
    private double latitude;
    private float altitude;

    public GpsPoint() {
        //Lege constructor
    }

    public GpsPoint(float velocity, double longitude, double latitude, float altitude) {
        super();

        this.velocity = velocity;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public GpsPoint(float velocity, double longitude, double latitude, float altitude, long millisec) {
        super(millisec);

        this.velocity = velocity;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getAltitude() {
        return altitude;
    }
}
