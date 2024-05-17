package weather;

public class Fog extends Weather {
    private int fogIntensity = 10;

    public Fog() {
        super();
        super.setSeverity(super.randNum.nextInt(fogIntensity) +1);
    }
} // class