package weather;

public class Sunny extends Weather {

    // no effect on battle
    private int sunIntensity = 0;

    public Sunny() {
        super();
        super.setSeverity(sunIntensity);
    }
} // class