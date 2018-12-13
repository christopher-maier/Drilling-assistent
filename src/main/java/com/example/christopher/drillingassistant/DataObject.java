package com.example.christopher.drillingassistant;

public class DataObject {
    //create an object of DataObject
    private static DataObject instance = new DataObject();
    private double length = 0;
    private double width = 0;
    private double holes = 0;
    private double distance = 0;
    private double diameter = 0;
    private double distanceToLength = 0;
    private double distanceToWidth = 0;

    public double getDistanceToLength() {
        return distanceToLength;
    }

    public void setDistanceToLength(double distanceToLength) {
        this.distanceToLength = distanceToLength;
    }

    public double getDistanceToWidth() {
        return distanceToWidth;
    }

    public void setDistanceToWidth(double distanceToWidth) {
        this.distanceToWidth = distanceToWidth;
    }

    //make the constructor private so that this class cannot be
    //instantiated
    private DataObject(){}

    //Get the only object available
    public static DataObject getInstance(){
        return instance;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

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

    public void showMessage(){
        System.out.println("hole= " + holes);
        System.out.println("distance= " + distance);
        System.out.println("diameter= " + diameter);
        System.out.println("width= " + width);
        System.out.println("length= " + length);
        System.out.println("distanceToLength= " + distanceToLength);
        System.out.println("distanceToWidth= " + distanceToWidth);
    }

}
