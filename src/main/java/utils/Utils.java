package utils;

import models.Building;
import models.Floor;
import models.Passenger;

import java.util.List;
import java.util.Random;

import static utils.Reversed.reversed;

public class Utils {
    public static Integer getRandomDirection() {
        return new Random().nextInt();
    }

    public static void showClip(Building building) {

        for (Floor f : reversed(building.getFloors())) {
            StringBuilder sb = new StringBuilder();
            sb.append(padRight(f.getIndex().toString() + "[" + f.getPassengersOut() + "]", 5)).append(" | ");
            if (building.getLift_on_floor() == f.getIndex()) {
                if (building.getLift_direction()) {
                    sb.append("↑ LIFT ↑ ");
                } else {
                    sb.append("↓ LIFT ↓ ");
                }
                sb.append("[");
                List<Passenger> passengersInLift = building.getLift().getPeople();
                StringBuilder sb2 = new StringBuilder();
                if (!(passengersInLift == null)) {
                    for (Passenger p : passengersInLift) {
                        sb2.append(p.getDestination().toString()).append(",");
                    }
                    sb2.append("]");
                    sb.append(padRight(sb2.toString(), 20));
                }

            } else {
                sb.append(padRight("", 30));
            }
            sb.append("|");
            for (Passenger p : f.getResidents()) {
                sb.append(p.getDestination().toString()).append(",");
            }
            System.out.println(sb);
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

}

