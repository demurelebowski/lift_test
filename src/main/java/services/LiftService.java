package services;

import models.Building;
import models.Floor;
import models.Lift;
import models.Passenger;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class LiftService {
    public static void run(Building building) {
        System.out.println(building.toString());
        int counter =0;
        do {
            System.out.println("Step " + (++counter));
            Utils.showClip(building);
            moveLift(building);
            System.out.println("_____________________________________");
            System.out.println();
        }
        while (building.getFloors().stream().anyMatch(i -> i.get().size()>0) || building.getLift().get().size()>0);
    }

    public static void moveLift(Building building) {

        Floor floor = building.getFloors().get(building.getLift_on_floor() - 1);
        Lift lift = building.getLift();

        int next_floor = 0;
        if (building.getLift_on_floor() == 1) {
            building.setLift_direction(true);
            next_floor = 2;
        } else if (building.getLift_on_floor() == building.getFloors().size()) {
            building.setLift_direction(false);
            next_floor = building.getFloors().size() - 1;
        } else if (building.getLift_direction() == true) {
            next_floor = floor.getIndex() + 1;
        } else if (building.getLift_direction() == false) {
            next_floor = floor.getIndex() - 1;
        }

        if (lift.get().stream().anyMatch(i -> i.getDestination() == floor.getIndex())) {
            List<Passenger> passengers_out = lift.get().stream().filter(i -> i.getDestination() == floor.getIndex()).collect(Collectors.toList());
            for (Passenger passenger : passengers_out) {
                lift.get().remove(passenger);
                floor.writePassengerOut();
            }
        }

        if (lift.getCapacity() > building.getLift().get().size()) {
            List<Passenger> passengers = floor.getPassengersWhoNeedThatWay(building.getLift_direction(), building.getLift().getCapacity() - building.getLift().get().size());
            if (!passengers.isEmpty()) {
                for (Passenger passenger : passengers) {
                    lift.put(passenger);
                    floor.getResidents().remove(passenger);
                }
            }
        }



        building.setLift_on_floor(next_floor);
    }
}
