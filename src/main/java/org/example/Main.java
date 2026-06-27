package org.example;

import org.example.models.ParkingLot;
import org.example.models.vehicle.Bus;
import org.example.models.vehicle.Car;
import org.example.models.vehicle.Motorcycle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance(3, 20);

        System.out.println(parkingLot.parkVehicle(new Car("DL01AA1111")));
        System.out.println(parkingLot.parkVehicle(new Motorcycle("DL01BB2222")));
        System.out.println(parkingLot.parkVehicle(new Bus("DL01CC3333")));
    }
}
