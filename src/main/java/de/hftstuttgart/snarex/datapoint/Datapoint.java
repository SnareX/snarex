package de.hftstuttgart.snarex.datapoint;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.Queue;

public class Datapoint{

    private double temperature;
    private double pressure;
    private double revolutions;


    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getRevolutions() {
        return revolutions;
    }

    public void setRevolutions(double revolutions) {
        this.revolutions = revolutions;
    }

    public double getTemperature() {

        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
