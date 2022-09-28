package models;

import java.util.ArrayList;
import java.util.List;

public class Lift implements HasPeople {
    private final int capacity = 5;
    private List<Passenger> passengers = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    @Override
    public List<Passenger> get() {

        return this.passengers;
    }

    @Override
    public void put(Passenger passenger) {
        this.passengers.add(passenger);
    }
}
