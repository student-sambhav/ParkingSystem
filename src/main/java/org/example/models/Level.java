package org.example.models;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> spots;
    private int availableSpots;

    public Level(int floor,int numSmall,int numMedium,int numLarge){
        this.floor=floor;
        spots=new ArrayList<>();
        availableSpots=numLarge+numSmall+numMedium;
        int id=0;
        for(int i=0;i<numSmall;i++){
            spots.add(new ParkingSpot(id++, SpotSize.SMALL,this));
        }
        for(int i=0;i<numMedium;i++)
            spots.add(new ParkingSpot(id++, SpotSize.MEDIUM,this));

        for(int i=0;i<numLarge;i++)
            spots.add(new ParkingSpot(id++, SpotSize.LARGE,this));
    }
    public synchronized boolean parkVehicle(Vehicle vehicle){

        if(availableSpots < vehicle.getSpotsNeeded())
            return false;

        List<ParkingSpot> list = findAvailableSpots(vehicle);

        if(list.size() < vehicle.getSpotsNeeded())
            return false;

        for(ParkingSpot spot:list)
            spot.park(vehicle);

        availableSpots -= vehicle.getSpotsNeeded();

        return true;
    }

    private List<ParkingSpot> findAvailableSpots(Vehicle vehicle){

        if(vehicle.getType()== VehicleType.BUS){

            List<ParkingSpot> ans=new ArrayList<>();

            int consecutive=0;

            for(ParkingSpot spot:spots){

                if(spot.isAvailable() && spot.getSize()==SpotSize.LARGE){

                    ans.add(spot);
                    consecutive++;

                    if(consecutive==vehicle.getSpotsNeeded())
                        return ans;
                }
                else{

                    ans.clear();
                    consecutive=0;
                }
            }

            return new ArrayList<>();
        }

        List<ParkingSpot> ans=new ArrayList<>();

        for(ParkingSpot spot:spots){

            if(spot.isAvailable() && vehicle.canFitInSpot(spot)){

                ans.add(spot);

                if(ans.size()==vehicle.getSpotsNeeded())
                    return ans;
            }
        }

        return ans;
    }
}
