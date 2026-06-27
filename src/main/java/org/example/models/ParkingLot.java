package org.example.models;

import org.example.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private static volatile ParkingLot instance;
    private ParkingLot(int numLevels,int spotsPerLevel){
        levels=new ArrayList<>();
        for(int i=0;i<numLevels;i++){
            int small=(int)(spotsPerLevel*0.2);
            int medium=(int)(spotsPerLevel*0.6);
            int large=spotsPerLevel-small-medium;
            levels.add(new Level(i,small,medium,large));
        }
    }
    public static ParkingLot getInstance(int levels,int spots){
        if(instance==null){
            synchronized (ParkingLot.class){
                if(instance==null){
                    instance=new ParkingLot(levels,spots);
                }
            }
        }
        return instance;
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if(level.parkVehicle(vehicle))
                return true;
        }
        return false;
    }

}
