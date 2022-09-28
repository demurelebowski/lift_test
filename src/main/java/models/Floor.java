package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Floor implements HasPeople {
    private List<Passenger> residents = new ArrayList<>();
    private int passengersOut;
    private Integer index;

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
        if (direction == true) {
            return this.residents.stream().filter(i -> i.getDestination() > this.index).limit(lift_capacity).collect(Collectors.toList());
        } else {
            return this.residents.stream().filter(i -> i.getDestination() < this.index).limit(lift_capacity).collect(Collectors.toList());
        }

    }

    @Override
    public List<Passenger> get() {

        return this.residents;
    }

    @Override
    public void put(Passenger passenger) {
        this.residents.add(passenger);
    }
}
