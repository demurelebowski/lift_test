package models;

import java.util.Random;

public class Passenger {
    private int destination;
    private Boolean arrived;

    public Passenger(int stories, int floor_index) {
        do {
            this.destination = new Random().nextInt(1, stories);
        }
        while (this.destination == floor_index);

    }

    public Boolean getArrived() {
        return arrived;
    }

    public void setArrived(Boolean arrived) {
        this.arrived = arrived;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }
}
