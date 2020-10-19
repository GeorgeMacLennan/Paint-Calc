package com.example.paintcalculatorapp;

public class InteriorRoom {
    public static final int WINDOW_AREA = 16;
    public static final int DOOR_AREA = 21;
    public static final int SQ_FT_PER_GALLON = 275;

    private double l;
    private double w;
    private double h;

    private int numOfDoors;
    private int numOfWindows;

    public void setLength(double length) {
        this.l = length;
    }

    public void setWidth(double width) {
        this.w = width;
    }

    public void setHeight(double height) {
        this.h = height;
    }

    public void setNumDoors(int numDoors) {
        this.numOfDoors = numDoors;
    }

    public void setNumWindows(int numWindows) {
        this.numOfWindows = numWindows;
    }

    public double computeWallArea()
    {
        return 2 * l * h + 2 * w * h + l * w;
    }

    public double getWindowDoorArea()
    {
        return numOfDoors * DOOR_AREA + numOfWindows * WINDOW_AREA;
    }

    public double getPaintArea()
    {
        return computeWallArea() - getWindowDoorArea();
    }

    public int getGallons()
    {
        return  (int)(Math.ceil(getPaintArea() / SQ_FT_PER_GALLON));
    }
}
