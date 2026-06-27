package org.example.models.vehicle;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;

public class Bus extends Vehicle{
    public Bus(String licensePlate) {
        super(licensePlate, VehicleType.BUS, 5, SpotSize.LARGE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot){
        return spot.getSize()==SpotSize.LARGE;
    }

}
