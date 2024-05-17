package weather;

import java.util.Random;

public abstract class Weather {
    protected Random randNum = new Random();
    public int severity;
    

    public Weather() {
        // do nothing
    }
    // Getters
    public int getSeverity() {
        return this.severity;
    }
// Setters
    public void setSeverity(int severity) {
        this.severity = severity;
    }


} // class