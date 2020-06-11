package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isWorking;
    
    public TemperatureSensor() {
        this.isWorking = false;        
    }

    @Override
    public boolean isOn() {
        return this.isWorking;
    }

    @Override
    public void setOn() {
        this.isWorking = true;
    }

    @Override
    public void setOff() {
        this.isWorking = false;
    }

    @Override
    public int read() {
        if (!this.isWorking) {
             throw new IllegalStateException();            
        }
        return new Random().nextInt(61) - 30;
    }
    
}
