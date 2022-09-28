package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Floor implements HasPeople {
    private final int index;
    private List<Passenger> residents;
    private int passengersOut;

    public Floor(Integer index, int stories) {
        this.index = index;
        this.residents = getRandomPassengers(stories);
    }

    public int getPassengersOut() {
        return passengersOut;
    }

    public void writePassengerOut() {
        this.passengersOut++;
    }

    public List<Passenger> getResidents() {
        return residents;
    }

    private List<Passenger> getRandomPassengers(int stories) {
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(5); i++) {
            passengers.add(new Passenger(stories, this.index));
        }
        return passengers;
    }

    public Integer getIndex() {
        return index;
    }

    public List<Passenger> getPassengersWhoNeedThatWay(Boolean direction, int lift_capacity) {
        if (direction) {
            return this.residents.stream().filter(i -> i.getDestination() > this.index).limit(lift_capacity).collect(Collectors.toList());
        } else {
            return this.residents.stream().filter(i -> i.getDestination() < this.index).limit(lift_capacity).collect(Collectors.toList());
        }

    }

    @Override
    public List<Passenger> getPeople() {

        return this.residents;
    }

    @Override
    public void putPeople(Passenger passenger) {
        this.residents.add(passenger);
    }

    @Override
    public int getMaxDesiredFloor() {
        if (!this.residents.isEmpty()) {
            return this.residents.stream().map(i -> i.getDestination()).mapToInt(i -> i).max().getAsInt();
        } else {
            return 0;
        }
    }
}
