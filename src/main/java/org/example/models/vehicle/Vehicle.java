package org.example.models.vehicle;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;

public class Vehicle {
    protected String liscensePlate;
    protected VehicleType type;
    protected int spotNeeded;
    protected SpotSize preferredSpotsize;

    public Vehicle(String liscensePlate, VehicleType type, int spotNeeded, SpotSize preferredSpotsize) {
        this.liscensePlate = liscensePlate;
        this.type = type;
        this.spotNeeded = spotNeeded;
        this.preferredSpotsize = preferredSpotsize;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }

    public String getLiscensePlate() {
        return liscensePlate;
    }


    public VehicleType getType() {
        return type;
    }

    public int getSpotsNeeded() {
        return spotNeeded;
    }

    public SpotSize getPreferredSpotsize() {
        return preferredSpotsize;
    }

}
