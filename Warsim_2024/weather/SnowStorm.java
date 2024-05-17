package weather;

public class SnowStorm extends Weather {

    private int stormIntensity = 75; // I suppose our Warriors are on Hoth

    public SnowStorm() {
        super();
        super.setSeverity(super.randNum.nextInt(stormIntensity) +1);
    }
} // class