package models;

import java.util.ArrayList;
import java.util.List;

public class Lift implements HasPeople {
    private final int capacity = 5;
    private List<Passenger> passengers = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public int getMaxDesiredFloor() {
        if (!this.passengers.isEmpty()) {
            return this.passengers.stream().map(i -> i.getDestination()).mapToInt(i -> i).max().getAsInt();
        } else {
            return 0;
        }
    }


    @Override
    public List<Passenger> getPeople() {

        return this.passengers;
    }

    @Override
    public void putPeople(Passenger passenger) {
        this.passengers.add(passenger);
    }
}
