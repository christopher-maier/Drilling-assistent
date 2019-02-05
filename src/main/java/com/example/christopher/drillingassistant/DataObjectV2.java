package com.example.christopher.drillingassistant;

public class DataObjectV2 {

    private static DataObjectV2 instance = new DataObjectV2();

    public double getHoles() {
        return holes;
    }

    public void setHoles(double holes) {
        this.holes = holes;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    private double holes = 0;
    private double distance = 0;
    private double diameter = 0;


    //make the constructor private so that this class cannot be
    //instantiated
    private DataObjectV2(){}

    //Get the only object available
    public static DataObjectV2 getInstance(){
        return instance;
    }

}
