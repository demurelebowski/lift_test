package services;

import models.Building;
import models.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuildingFactory {
    public static Building build() {
        return new Building(create_floors(new Random().nextInt(5, 20)));
    }

    ;

    private static List<Floor> create_floors(int stories) {

        List<Floor> floors = new ArrayList<>();

        for (int i = 1; i < stories + 1; i++) {
            floors.add(new Floor(i, stories));
        }
        ;
        return floors;
    }
}
