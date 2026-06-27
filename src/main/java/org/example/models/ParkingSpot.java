package org.example.models;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.vehicle.Vehicle;

public class ParkingSpot {
    private int id;
    private SpotSize size;
    private Vehicle vehicle;
    private boolean isAvailable;
    private Level level;

    public ParkingSpot(int id, SpotSize size, Level level) {
        this.id = id;
        this.size = size;
        this.level = level;
        this.isAvailable = true;
    }

    public boolean park(Vehicle vehicle){
        if(!isAvailable || !vehicle.canFitInSpot(this)){
            return false;
        }
        this.vehicle=vehicle;
        isAvailable=false;
        return true;
    }
    public void removeVehicle(){
        vehicle=null;
        isAvailable=true;
    }
    public SpotSize getSize(){
        return size;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

}
