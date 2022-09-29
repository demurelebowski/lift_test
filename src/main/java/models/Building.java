package models;

import java.util.List;

public class Building {
    List<Floor> floors;
    Lift lift;
    Boolean lift_direction; // true = up
    int lift_on_floor;

    public Building(List<Floor> floors) {
        this.floors = floors;
        this.lift = new Lift();
        this.lift_direction = true;
        lift_on_floor = 1;
    }

    public Lift getLift() {
        return lift;
    }

    public Boolean getLift_direction() {
        return lift_direction;
    }

    public void setLift_direction(Boolean lift_direction) {
        this.lift_direction = lift_direction;
    }

    public Integer getLift_on_floor() {
        return lift_on_floor;
    }

    public void setLift_on_floor(Integer lift_on_floor) {
        this.lift_on_floor = lift_on_floor;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public int getMaxDesiredFloor() {

        if (this.floors.isEmpty()) {
            return 0;
        } else {
            return this.floors.stream().mapToInt(i -> i.getMaxDesiredFloor()).max().getAsInt();
        }

    }

    public int getMaxFloorWithPassengers() {
        if (this.floors.isEmpty()) {
            return 0;
        } else {
            if (this.floors.stream().anyMatch(i -> i.getResidents().size() > 0)) {
                return this.floors.stream().filter(i -> i.getResidents().size() > 0).mapToInt(i -> i.getIndex()).max().getAsInt();
            } else {
                return 0;
            }
        }
    }
    public int getMinFloorWithPassengers() {
        if (this.floors.isEmpty()) {
            return 0;
        } else {
            if (this.floors.stream().anyMatch(i -> i.getResidents().size() > 0)) {
                return this.floors.stream().filter(i -> i.getResidents().size() > 0).mapToInt(i -> i.getIndex()).min().getAsInt();
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors.size() +
                ", lift=" + lift +
                ", lift_direction=" + lift_direction +
                ", lift_on_floor=" + lift_on_floor +
                '}';
    }
}
